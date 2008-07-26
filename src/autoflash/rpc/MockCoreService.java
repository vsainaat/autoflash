package autoflash.rpc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.ActivityType;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.BatteryState;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.DepotQueryCondition;
import autoflash.rpc.slice.OpenStatus;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

// 这个类用于保存与加电站相关的所有信息
class StationStatus {
	StationInfo info;

	boolean isOpen;

	HashSet<String> batteries;
}

// 这个类用于保存与充电站相关的所有信息
class DepotStatus {
	DepotInfo info;

	boolean isOpen;

	HashSet<String> batteries;
}

// 这个类用于保存与车辆有关的所有信息
class VehicleStatus {
	VehicleInfo info;

	HashSet<String> batteries;

	long lastChargeDate;
}

// 这个类用于保存与电池有关的所有信息
class BatteryStatus {
	BatteryInfo info;

	BatteryState state;

	int chargeRound = 0;
}

/**
 * MockCoreService是对CoreService的模拟类，只用于调试其他部分。 为了模拟整个环境，在内存中模拟存储了所有的信息。
 */
public class MockCoreService {
	private HashMap<String, StationStatus> cStations_ = new HashMap<String, StationStatus>();

	private HashMap<String, VehicleStatus> cVehicles_ = new HashMap<String, VehicleStatus>();

	private HashMap<String, BatteryStatus> cBatteries_ = new HashMap<String, BatteryStatus>();

	private HashMap<String, DepotStatus> cDepots_ = new HashMap<String, DepotStatus>();

	private HashSet<String> cTransportingBatteries = new HashSet<String>();

	private List<Activity> history = new ArrayList<Activity>();

	private double unitPrice = 9.9;

	private double unitChargePrice = 4.9;

	private void checkStation(String stationID) throws OperationError {
		if (!cStations_.containsKey(stationID)) throw new OperationError("Station not found.");
		if (!cStations_.get(stationID).isOpen) throw new OperationError("Station is closed.");
	}

	private void checkDepot(String depotID) throws OperationError {
		if (!cDepots_.containsKey(depotID)) throw new OperationError("Depot not found.");
		if (!cDepots_.get(depotID).isOpen) throw new OperationError("Depot is cloesd.");
	}

	private void checkBattery(String batteryID) throws OperationError {
		if (!cBatteries_.containsKey(batteryID)) throw new OperationError("Battery not found.");
	}

	private void checkVehicle(String vehicleID) throws OperationError {
		if (!cVehicles_.containsKey(vehicleID)) throw new OperationError("Vehicle not found.");
	}

	private void checkBatteryInStation(String batteryID, String stationID) throws OperationError {
		checkStation(stationID);
		checkBattery(batteryID);
		if (!cStations_.get(stationID).batteries.contains(batteryID)) throw new OperationError(
				"Battery not found in this station.");
	}

	private void checkBatteryInDepot(String batteryID, String depotID) throws OperationError {
		checkDepot(depotID);
		checkBattery(batteryID);
		if (!cDepots_.get(depotID).batteries.contains(batteryID)) throw new OperationError(
				"Battery not found in this depot.");
	}

	private void checkBatteryInVehicle(String batteryID, String vehicleID) throws OperationError {
		checkVehicle(vehicleID);
		checkBattery(batteryID);
		if (!cVehicles_.get(vehicleID).batteries.contains(batteryID)) throw new OperationError(
				"Battery not found in this vehicle.");
	}

	private void checkBatteryInTransportation(String batteryID) throws OperationError {
		checkBattery(batteryID);
		if (!cTransportingBatteries.contains(batteryID)) throw new OperationError(
				"Battery not found in transportation.");
	}

	public double rentBattery(String stationID, String vehicleID, String batteryID, double amount)
			throws OperationError {
		// logdebug("Vehicle %s rent battery %s in station %s with amount %f.",
		// vehicleID, batteryID, stationID, amount);
		// logdebug("Cost " + amount * 9.9);
		checkVehicle(vehicleID);
		checkBatteryInStation(batteryID, stationID);
		assert cBatteries_.get(batteryID).state == BatteryState.Charged;
		cBatteries_.get(batteryID).state = BatteryState.Onboard;
		cStations_.get(stationID).batteries.remove(batteryID);
		cVehicles_.get(vehicleID).batteries.add(batteryID);
		long t = new Date().getTime();
		cVehicles_.get(vehicleID).lastChargeDate = t;
		double price = amount * unitPrice;
		history.add(new Activity(t, ActivityType.Rent, batteryID, vehicleID, stationID, price));
		return price;
	}

	public double returnBattery(String stationID, String vehicleID, String batteryID, double amount)
			throws OperationError {
		//logdebug("Vehicle %s return battery %s in station %s with amount %f.",
		// vehicleID, batteryID, stationID, amount);
		// logdebug("Cost -" + amount * 9.9);
		checkStation(stationID);
		checkBatteryInVehicle(batteryID, vehicleID);
		assert cBatteries_.get(batteryID).state == BatteryState.Onboard;
		cBatteries_.get(batteryID).state = BatteryState.Empty;
		cStations_.get(stationID).batteries.add(batteryID);
		cVehicles_.get(vehicleID).batteries.remove(batteryID);
		double price = -amount * unitPrice;
		history.add(new Activity(new Date().getTime(), ActivityType.Return, batteryID, vehicleID, stationID, price));
		return price;
	}

	public void moveBatteryToStation(String stationID, String batteryID) throws OperationError {
		// logdebug("Move battery %s to station %s.", batteryID, stationID);
		checkStation(stationID);
		checkBatteryInTransportation(batteryID);
		cTransportingBatteries.remove(batteryID);
		cStations_.get(stationID).batteries.add(batteryID);
		logdebug("Station %s has %d batteries", stationID, cStations_.get(stationID).batteries.size());
		// logdebug(cStations_.get(stationID).batteries.toString());
		history.add(new Activity(new Date().getTime(), ActivityType.MoveToStation, batteryID, "", stationID, 0));
	}

	public void moveBatteryFromStation(String stationID, String batteryID) throws OperationError {
		// logdebug("Move battery %s from station %s.", batteryID, stationID);
		checkBatteryInStation(batteryID, stationID);
		cStations_.get(stationID).batteries.remove(batteryID);
		cTransportingBatteries.add(batteryID);
		logdebug("Station %s has %d batteries", stationID, cStations_.get(stationID).batteries.size());
		// logdebug(cStations_.get(stationID).batteries.toString());
		history.add(new Activity(new Date().getTime(), ActivityType.MoveFromStation, batteryID, "", stationID, 0));
	}

	public void reportDamagedBattery(String stationID, String batteryID) throws OperationError {
		checkBattery(batteryID);
		checkStation(stationID);
		cBatteries_.get(batteryID).state = BatteryState.Discarded;
		cStations_.get(stationID).batteries.remove(batteryID);
		logdebug("Report damaged battery %s from station %s, discard.", batteryID, stationID);
		history.add(new Activity(new Date().getTime(), ActivityType.Discard, batteryID, "", stationID, 0));
	}

	public String registerVehicle(String stationID, VehicleInfo info) throws OperationError {
		checkStation(stationID);
		Random rand = new Random();
		do {
			info.ID = "V" + rand.nextInt(99999);
		} while (cStations_.containsKey(info.ID));
		VehicleStatus vs = new VehicleStatus();
		vs.info = info;
		vs.batteries = new HashSet<String>();
		cVehicles_.put(info.ID, vs);
		logdebug("Register vehicle : " + info.ID);
		history.add(new Activity(new Date().getTime(), ActivityType.Register, "", info.ID, "", 0));
		return info.ID;
	}

	public void openStation(String stationID) {
		cStations_.get(stationID).isOpen = true;
		history.add(new Activity(new Date().getTime(), ActivityType.OpenStation, "", "", stationID, 0));
		// logdebug("Station %s opens.", stationID);
	}

	public void closeStation(String stationID) {
		cStations_.get(stationID).isOpen = false;
		history.add(new Activity(new Date().getTime(), ActivityType.CloseStation, "", "", stationID, 0));
		// logdebug("Station %s closes.", stationID);
	}

	public void moveBatteryToDepot(String depotID, String batteryID) throws OperationError {
		// logdebug("Move battery %s to depot %s.", batteryID, depotID);
		checkDepot(depotID);
		checkBatteryInTransportation(batteryID);
		cTransportingBatteries.remove(batteryID);
		cDepots_.get(depotID).batteries.add(batteryID);
		logdebug("Depot %s has %d batteries", depotID, cDepots_.get(depotID).batteries.size());
		// logdebug(cDepots_.get(depotID).batteries.toString());
		history.add(new Activity(new Date().getTime(), ActivityType.MoveToDepot, batteryID, "", depotID, 0));
	}

	public void moveBatteryFromDepot(String depotID, String batteryID) throws OperationError {
		// logdebug("Move battery %s from depot %s.", batteryID, depotID);
		checkBatteryInDepot(batteryID, depotID);
		cDepots_.get(depotID).batteries.remove(batteryID);
		cTransportingBatteries.add(batteryID);
		logdebug("Depot %s has %d batteries", depotID, cDepots_.get(depotID).batteries.size());
		// logdebug(cDepots_.get(depotID).batteries.toString());
		history.add(new Activity(new Date().getTime(), ActivityType.MoveFromDepot, batteryID, "", depotID, 0));
	}

	public void charge(String depotID, String batteryID, double currentAmount, double useAmount) throws OperationError {
		// logdebug("Charge battery %s in depot %s use amout %f.", batteryID,
		// depotID, useAmount);
		checkBatteryInDepot(batteryID, depotID);
		cBatteries_.get(batteryID).state = BatteryState.Charged;
		cBatteries_.get(batteryID).chargeRound++;
		double price = -useAmount * unitChargePrice;
		history.add(new Activity(new Date().getTime(), ActivityType.Charge, batteryID, "", depotID, price));
	}

	public void discard(String depotID, String batteryID) throws OperationError {
		checkBatteryInDepot(batteryID, depotID);
		logdebug("Discard battery %s in depot %s, unimplemented.", batteryID, depotID);
		history.add(new Activity(new Date().getTime(), ActivityType.Discard, batteryID, "", depotID, 0));
	}

	public void openDepot(String depotID) {
		cDepots_.get(depotID).isOpen = true;
		history.add(new Activity(new Date().getTime(), ActivityType.Discard, "", "", depotID, 0));
	}

	public void closeDepot(String depotID) {
		cDepots_.get(depotID).isOpen = false;
		history.add(new Activity(new Date().getTime(), ActivityType.Discard, "", "", depotID, 0));
	}

	public String purchase(BatteryInfo info, double price) {
		Random rand = new Random();
		do {
			info.ID = "B" + rand.nextInt(9999999);
		} while (cBatteries_.containsKey(info.ID));
		BatteryStatus bs = new BatteryStatus();
		bs.info = info;
		bs.state = BatteryState.Empty;
		cBatteries_.put(info.ID, bs);
		cTransportingBatteries.add(info.ID);
		logdebug("Register new battery " + info.ID);
		history.add(new Activity(new Date().getTime(), ActivityType.Purchase, info.ID, "", "", -price));
		return info.ID;
	}

	public Activity[] queryActivities(long start, long end) {
		Activity startActivity = new Activity();
		startActivity.time = start;
		Activity endActivity = new Activity();
		endActivity.time = end;
		int sindex = Collections.binarySearch(history, startActivity, new Comparator<Activity>() {
			public int compare(Activity o1, Activity o2) {
				return (int) (o1.time - o2.time);
			}
		});
		int eindex = Collections.binarySearch(history, endActivity, new Comparator<Activity>() {
			public int compare(Activity o1, Activity o2) {
				return (int) (o1.time - o2.time);
			}
		});
		if (sindex < 0) sindex = -sindex -1;
		if (eindex < 0) eindex = -eindex -1;
		logdebug(history.size() + " :from " + sindex + " to " + eindex);
		return history.subList(sindex, eindex).toArray(new Activity[0]);
	}

	public Activity[] queryBatteryActivities(String batteryID, long start, long end) {
		Activity[] activities = queryActivities(start, end);
		List<Activity> bactivities = new ArrayList<Activity>();
		for (Activity a:activities) {
			if (a.batteryID == batteryID)
				bactivities.add(a);
		}
		return bactivities.toArray(new Activity[0]);
	}

	public Activity[] queryStationActivities(String stationID, long start, long end) {
		Activity[] activities = queryActivities(start, end);
		List<Activity> sactivities = new ArrayList<Activity>();
		for (Activity a:activities) {
			if (a.stationOrDepotID == stationID)
				sactivities.add(a);
		}
		return sactivities.toArray(new Activity[0]);
	}

	public Activity[] queryDepotActivities(String depotID, long start, long end) {
		Activity[] activities = queryActivities(start, end);
		List<Activity> dactivities = new ArrayList<Activity>();
		for (Activity a:activities) {
			if (a.stationOrDepotID == depotID)
				dactivities.add(a);
		}
		return dactivities.toArray(new Activity[0]);
	}

	public StationInfo[] queryStations(StationQueryCondition c) {
		ArrayList<StationInfo> as = new ArrayList<StationInfo>();
		Iterator<StationStatus> iter = cStations_.values().iterator();
		while (iter.hasNext()) {
			StationStatus ss = iter.next();
			if (c.stationID != "" && !ss.info.ID.equals(c.stationID)) continue;
			if (c.owner != "" && !ss.info.owner.equals(c.owner)) continue;
			if (c.status == OpenStatus.Closed && ss.isOpen) continue;
			if (c.status == OpenStatus.Open && !ss.isOpen) continue;
			if (c.maxCapacity < ss.info.capacity || c.minCapacity > ss.info.capacity) continue;
			if (c.region.topLeftCorner.latitude > ss.info.position.latitude
					|| c.region.topLeftCorner.longitude > ss.info.position.longitude
					|| c.region.topLeftCorner.latitude + c.region.latitudeSpan < ss.info.position.latitude
					|| c.region.topLeftCorner.longitude + c.region.longitudeSpan < ss.info.position.longitude) continue;
			as.add(ss.info);
		}
		logdebug("Query stations, return " + as.size() + " results");
		return as.toArray(new StationInfo[0]);
	}

	public DepotInfo[] queryDepots(DepotQueryCondition c) {
		ArrayList<DepotInfo> as = new ArrayList<DepotInfo>();
		Iterator<DepotStatus> iter = cDepots_.values().iterator();
		while (iter.hasNext()) {
			DepotStatus ss = iter.next();
			if (c.depotID != "" && !ss.info.ID.equals(c.depotID)) continue;
			if (c.owner != "" && !ss.info.owner.equals(c.owner)) continue;
			if (c.status == OpenStatus.Closed && ss.isOpen) continue;
			if (c.status == OpenStatus.Open && !ss.isOpen) continue;
			if (c.maxChargeCapacity < ss.info.chargeCapacity || c.minChargeCapacity > ss.info.chargeCapacity) continue;
			if (c.maxStorageCapacity < ss.info.storageCapacity || c.minStorageCapacity > ss.info.storageCapacity) continue;
			if (c.region.topLeftCorner.latitude > ss.info.position.latitude
					|| c.region.topLeftCorner.longitude > ss.info.position.longitude
					|| c.region.topLeftCorner.latitude + c.region.latitudeSpan < ss.info.position.latitude
					|| c.region.topLeftCorner.longitude + c.region.longitudeSpan < ss.info.position.longitude) continue;
			as.add(ss.info);
		}
		logdebug("Query depots, return " + as.size() + " results");
		return as.toArray(new DepotInfo[0]);
	}

	public BatteryInfo[] queryBatteries(BatteryQueryCondition c) {
		ArrayList<BatteryInfo> as = new ArrayList<BatteryInfo>();
		Iterator<BatteryStatus> iter = cBatteries_.values().iterator();
		while (iter.hasNext()) {
			BatteryStatus ss = iter.next();
			if (c.batteryID != "" && !ss.info.ID.equals(c.batteryID)) continue;
			if (c.vehicleID != "" && cVehicles_.containsKey(c.vehicleID)
					&& !cVehicles_.get(c.vehicleID).batteries.contains(c.vehicleID)) continue;
			if (c.maxChargeRounds < ss.chargeRound || c.minChargeRounds > ss.chargeRound) continue;
			if (c.maxShippedDate < ss.info.shippedDate || c.minShippedDate > ss.info.shippedDate) continue;
			if (c.model.name != "" && !ss.info.model.name.equals(c.model.name)) continue;
			if (c.state != BatteryState.Arbitrary && c.state != ss.state) {
				// logdebug("Battery " + ss.info.ID +
				// " violate state condition:" + c.state + " vs " + ss.state);
				continue;
			}
			if (c.stationID != ""
					&& (!cStations_.containsKey(c.stationID) || !cStations_.get(c.stationID).batteries
							.contains(ss.info.ID))) {
				// logdebug("Battery " + ss.info.ID +
				// " violate station condition: " + c.stationID + " " +
				// ss.info.ID);
				// logdebug(cStations_.get(c.stationID).batteries.toString());
				continue;

			}
			if (c.depotID != ""
					&& (!cDepots_.containsKey(c.depotID) || !cDepots_.get(c.depotID).batteries.contains(ss.info.ID))) {
				// logdebug("Battery " + ss.info.ID +
				// " violate depot condition: " + c.depotID + " " + ss.info.ID);
				// logdebug(cDepots_.get(c.depotID).batteries.toString());
				continue;
			}
			as.add(ss.info);
		}
		logdebug("Query batteries, return " + as.size() + " results");
		return as.toArray(new BatteryInfo[0]);
	}

	public VehicleInfo[] queryVehicles(VehicleQueryCondition c) {
		ArrayList<VehicleInfo> as = new ArrayList<VehicleInfo>();
		Iterator<VehicleStatus> iter = cVehicles_.values().iterator();
		while (iter.hasNext()) {
			VehicleStatus vs = iter.next();
			if (c.license != "" && !vs.info.license.equals(c.license)) continue;
			if (c.vehicleID != "" && !vs.info.ID.equals(c.vehicleID)) continue;
			if (c.owner != "" && !vs.info.owner.equals(c.owner)) continue;
			if (c.batteryID != "" && !vs.batteries.contains(c.batteryID)) continue;
			if (c.batteryNum >= 0 && vs.batteries.size() != c.batteryNum) continue;
			if (c.model != "" && !vs.info.model.equals(c.model)) continue;
			if (c.maxChargeDate < vs.lastChargeDate || c.minChargeDate > vs.lastChargeDate) continue;
			as.add(vs.info);
		}
		logdebug("Query vehicles, return " + as.size() + " results");
		return as.toArray(new VehicleInfo[0]);
	}

	public String registerStation(StationInfo info) {
		Random rand = new Random();
		do {
			info.ID = "S" + rand.nextInt(9999);
		} while (cStations_.containsKey(info.ID));
		StationStatus ss = new StationStatus();
		ss.info = info;
		ss.isOpen = false;
		ss.batteries = new HashSet<String>();
		cStations_.put(info.ID, ss);
		logdebug("Register station : " + info.ID);
		history.add(new Activity(new Date().getTime(), ActivityType.Register, "", "", info.ID, 0));
		return info.ID;
	}

	public void unregisterStation(String stationID) throws OperationError {
		checkStation(stationID);
		assert cStations_.get(stationID).batteries.size() == 0;
		cStations_.remove(stationID);
		history.add(new Activity(new Date().getTime(), ActivityType.Unregister, "", "", stationID, 0));
	}

	public void setStation(String stationID, StationInfo info) throws OperationError {
		checkStation(stationID);
		cStations_.get(stationID).info = info;
		history.add(new Activity(new Date().getTime(), ActivityType.Set, "", "", stationID, 0));
	}

	public String registerDepot(DepotInfo info) {
		Random rand = new Random();
		do {
			info.ID = "D" + rand.nextInt(9999);
		} while (cStations_.containsKey(info.ID));

		DepotStatus ds = new DepotStatus();
		ds.info = info;
		ds.isOpen = false;
		ds.batteries = new HashSet<String>();
		cDepots_.put(info.ID, ds);
		logdebug("Register depot : " + info.ID);
		return info.ID;
	}

	public void unregisterDepot(String depotID) throws OperationError {
		checkDepot(depotID);
		assert cDepots_.get(depotID).batteries.size() == 0;
		cDepots_.remove(depotID);
		history.add(new Activity(new Date().getTime(), ActivityType.Unregister, "", "", depotID, 0));
	}

	public void setDepot(String depotID, DepotInfo info) throws OperationError {
		checkDepot(depotID);
		cDepots_.get(depotID).info = info;
		history.add(new Activity(new Date().getTime(), ActivityType.Set, "", "", depotID, 0));
	}

	static void loginfo(String format, Object... args) {
		logger.info(new Formatter().format(format, args));
	}

	static void logerror(String format, Object... args) {
		logger.error(new Formatter().format(format, args));
	}

	static void logdebug(String format, Object... args) {
		logger.debug(new Formatter().format(format, args));
	}

	static private Logger logger = Logger.getLogger("MockCoreService");
	static {
		Layout layout = new PatternLayout("%d [%c] %p - %m\n");
		logger.addAppender(new ConsoleAppender(layout));
		DailyRollingFileAppender rfa = null;
		try {
			rfa = new DailyRollingFileAppender(layout, "autoflash_server.log", ".yyyy-MM-dd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.fatal("Catch exception when initialzing logger:", e);
			System.exit(1);
		}
		logger.addAppender(rfa);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginfo("Test MockCoreService: Do nothing.");
	}

}

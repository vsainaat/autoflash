
package autoflash.rpc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.BatteryState;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.DepotQueryCondition;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

// 这个类用于保存与加电站相关的所有信息
class StationStatus {
	StationInfo info;
	boolean open;
	HashSet<String> batteries;
}

// 这个类用于保存与充电站相关的所有信息
class DepotStatus {
	DepotInfo info;
	boolean open;
	HashSet<String> batteries;
}

// 这个类用于保存与车辆有关的所有信息
class VehicleStatus {
	VehicleInfo info;
	//ArrayList<String> batteries;
}

// 这个类用于保存与电池有关的所有信息
class BatteryStatus {
	BatteryInfo info;
	BatteryState state;
}

/**
 * MockCoreService是对CoreService的模拟类，只用于调试其他部分。
 * 为了模拟整个环境，在内存中模拟存储了所有的信息。
 */
public class MockCoreService {
    private HashMap<String, StationStatus> 	hmStations_ = new HashMap<String, StationStatus>();   
    private HashMap<String, VehicleStatus> 	hmVehicles_ = new HashMap<String, VehicleStatus>();
    private HashMap<String, BatteryStatus>	hmBatteries_ = new HashMap<String, BatteryStatus>();
    private HashMap<String, DepotStatus>	hmDepots_ = new HashMap<String, DepotStatus>();

	public double rentBattery(String stationID, String vehicleID, String batteryID, double amount) { 
		//logdebug("Vehicle %s rent battery %s in station %s with amount %f.", vehicleID, batteryID, stationID, amount);
		//logdebug("Cost " + amount * 9.9);
		assert hmBatteries_.containsKey(batteryID);
		assert hmVehicles_.containsKey(vehicleID);
		assert hmStations_.containsKey(stationID);
		BatteryStatus bs = hmBatteries_.get(batteryID);
		assert bs.state == BatteryState.Charged;
		bs.state = BatteryState.Onboard;
		hmBatteries_.put(batteryID, bs);
		StationStatus ss = hmStations_.get(stationID);
		ss.batteries.remove(batteryID);
		hmStations_.put(stationID, ss);
		return amount * 9.9; 
	}
	public double returnBattery(String stationID, String vehicleID, String batteryID, double amount) { 
		//logdebug("Vehicle %s return battery %s in station %s with amount %f.", vehicleID, batteryID, stationID, amount);
		//logdebug("Cost -" + amount * 9.9);
		assert hmBatteries_.containsKey(batteryID);
		assert hmStations_.containsKey(stationID);
		assert hmVehicles_.containsKey(vehicleID);
		BatteryStatus bs = hmBatteries_.get(batteryID);
		assert bs.state == BatteryState.Onboard;
		bs.state = BatteryState.Empty;
		hmBatteries_.put(batteryID, bs);
		StationStatus ss = hmStations_.get(stationID);
		ss.batteries.add(batteryID);
		hmStations_.put(stationID, ss);
		return amount * 9.9;
	}
	 
	public void moveBatteryToStation(String stationID, String batteryID) {
		logdebug("Move battery %s to station %s.", batteryID, stationID);
		assert hmBatteries_.containsKey(batteryID);
		assert hmStations_.containsKey(stationID);
		StationStatus ss = hmStations_.get(stationID);
		assert !ss.batteries.contains(batteryID);
		ss.batteries.add(batteryID);
		hmStations_.put(stationID, ss);
		logdebug("Station %s has %d batteries", stationID, ss.batteries.size());
		//logdebug(hmStations_.get(stationID).batteries.toString());
	}
	
	public void moveBatteryFromStation(String stationID, String batteryID) { 
		//logdebug("Move battery %s from station %s.", batteryID, stationID);
		assert hmBatteries_.containsKey(batteryID);
		assert hmStations_.containsKey(stationID);
		StationStatus ss = hmStations_.get(stationID);
		assert ss.batteries.contains(batteryID);
		ss.batteries.remove(batteryID);
		hmStations_.put(stationID, ss);
		logdebug("Station %s has %d batteries", stationID, ss.batteries.size());
		//logdebug(hmStations_.get(stationID).batteries.toString());
	}

    public void reportDamagedBattery(String stationID, String batteryID) { 
		assert hmBatteries_.containsKey(batteryID);
		assert hmStations_.containsKey(stationID);
    	logdebug("Report damaged battery %s from station %s, unimplemented.", batteryID, stationID);
    }

    public String registerVehicle(String stationID, VehicleInfo info) {    
		Random rand = new Random();
		do {
			info.ID = "V" + rand.nextInt(99999);
		} while(hmStations_.containsKey(info.ID));
		VehicleStatus vs = new VehicleStatus();
		vs.info = info;
		//vs.batteries = new HashSet<String>();
		hmVehicles_.put(info.ID, vs);
    	logdebug("Register vehicle : " + info.ID);
		return info.ID;
	}

    public void openStation(String stationID) { 
    	StationStatus ss = hmStations_.get(stationID);
    	ss.open = true;
    	hmStations_.put(stationID, ss);
    	//logdebug("Station %s opens.", stationID);
    }
    public void closeStation(String stationID) {
    	StationStatus ss = hmStations_.get(stationID);
    	ss.open = false;
    	hmStations_.put(stationID, ss);
    	//logdebug("Station %s closes.", stationID);
    }

	public void moveBatteryToDepot(String depotID, String batteryID) { 
		//logdebug("Move battery %s to depot %s.", batteryID, depotID);
		assert hmBatteries_.containsKey(batteryID);
		assert hmDepots_.containsKey(depotID);
		DepotStatus ds = hmDepots_.get(depotID);
		ds.batteries.add(batteryID);
		hmDepots_.put(depotID, ds);
		logdebug("Depot %s has %d batteries", depotID, ds.batteries.size());
		//logdebug(hmDepots_.get(depotID).batteries.toString());
	}
	public void moveBatteryFromDepot(String depotID, String batteryID) { 
		//logdebug("Move battery %s from depot %s.", batteryID, depotID);
		assert hmBatteries_.containsKey(batteryID);
		assert hmDepots_.containsKey(depotID);
		DepotStatus ds = hmDepots_.get(depotID);
		ds.batteries.remove(batteryID);
		hmDepots_.put(depotID, ds);
		logdebug("Depot %s has %d batteries", depotID, ds.batteries.size());
		//logdebug(hmDepots_.get(depotID).batteries.toString());
	}
	
	public void charge(String depotID, String batteryID, double currentAmount, double useAmount) {
		//logdebug("Charge battery %s in depot %s use amout %f.", batteryID, depotID, useAmount);
		assert hmBatteries_.containsKey(batteryID);
		assert hmDepots_.containsKey(depotID);
		BatteryStatus bs = hmBatteries_.get(batteryID);
		bs.state = BatteryState.Charged;
		hmBatteries_.put(batteryID, bs);
	}
	
	public void discard(String depotID, String batteryID) {
		assert hmBatteries_.containsKey(batteryID);
		assert hmDepots_.containsKey(depotID);
		logdebug("Discard battery %s in depot %s, unimplemented.", batteryID, depotID);
	}
	
    public void openDepot(String depotID) {
    	DepotStatus ds = hmDepots_.get(depotID);
    	ds.open = true;
    	hmDepots_.put(depotID, ds);
    	//logdebug("Depot %s openes.", depotID);
    }
    public void closeDepot(String depotID) { 
    	DepotStatus ds = hmDepots_.get(depotID);
    	ds.open = false;
    	hmDepots_.put(depotID, ds);
    	//logdebug("Depot %s closed.", depotID);
    }

	public String purchase(BatteryInfo info) {
    	Random rand = new Random();
    	do {
    		info.ID = "B" + rand.nextInt(9999999);
    	} while (hmBatteries_.containsKey(info.ID));
		BatteryStatus bs = new BatteryStatus();
		bs.info = info;
		bs.state = BatteryState.Empty;
		hmBatteries_.put(info.ID, bs);
		logdebug("Register new battery " + info.ID);
		return info.ID;
	}
	
    public Activity[] queryActivities(int start, int end) {
		logdebug("Query activities, unimplemented.");
		return null;
	}

	public Activity[] queryBatteryActivities(String batteryID, int start, int end) {
		logdebug("Query battery activities, unimplemented.");
		return null;
	}

	public Activity[] queryStationActivities(String stationID, int start, int end) {
		logdebug("Query station activities, unimplemented.");
		return null;
	}

	public Activity[] queryDepotActivities(String stationID, int start, int end) {
		logdebug("Query depot activities, unimplemented.");
		return null;
	}

	// 暂时只返回所有的加电站
	public StationInfo[] queryStations(StationQueryCondition c) { 
		//logdebug("Query stations, currently just return all stations.");
		ArrayList<StationInfo> as = new ArrayList<StationInfo>();
		Iterator<StationStatus> iter = hmStations_.values().iterator();
		while (iter.hasNext()) {
			StationStatus ss = iter.next();
			as.add(ss.info);
		}
		StationInfo[] si = new StationInfo[as.size()];
		return as.toArray(si);
	}
	
	// 暂时只返回所有的充电站
	public DepotInfo[] queryDepots(DepotQueryCondition c) { 
		//logdebug("Query depots, currently just return all depots.");
		ArrayList<DepotInfo> as = new ArrayList<DepotInfo>();
		Iterator<DepotStatus> iter = hmDepots_.values().iterator();
		while (iter.hasNext()) {
			DepotStatus ss = iter.next();
			as.add(ss.info);
		}
		DepotInfo[] di = new DepotInfo[as.size()];
		return  as.toArray(di);
	}
	
	// 目前检查state, stationID, depotID
	public BatteryInfo[] queryBatteries(BatteryQueryCondition c) { 
		//logdebug("Query batteries, currently check state, stationID, depotID.");
		ArrayList<BatteryInfo> as = new ArrayList<BatteryInfo>();
		Iterator<BatteryStatus> iter = hmBatteries_.values().iterator();
		while (iter.hasNext()) {
			BatteryStatus ss = iter.next();
			if (c.state != BatteryState.Arbitrary && c.state != ss.state) {
				//logdebug("Battery " + ss.info.ID + " violate state condition:" + c.state + " vs " + ss.state);
				continue;
			}
			if (c.stationID.length() > 0 && (!hmStations_.containsKey(c.stationID)
					|| !hmStations_.get(c.stationID).batteries.contains(ss.info.ID))) {
				//logdebug("Battery " + ss.info.ID + " violate station condition: " + c.stationID + " " + ss.info.ID);
				//logdebug(hmStations_.get(c.stationID).batteries.toString());
				continue;
				
			}
			if (c.depotID.length() > 0 && (!hmDepots_.containsKey(c.depotID)
					|| !hmDepots_.get(c.depotID).batteries.contains(ss.info.ID))){
				//logdebug("Battery " + ss.info.ID + " violate depot condition: " + c.depotID + " " + ss.info.ID);
				//logdebug(hmDepots_.get(c.depotID).batteries.toString());
				continue;
			}
			as.add(ss.info);
		}
		logdebug("Query batteries, return " + as.size() + " results");
		BatteryInfo[] bi = new BatteryInfo[as.size()];
		return  as.toArray(bi);
	}
	
	// 暂时只返回所有车辆
	public VehicleInfo[] queryVehicles(VehicleQueryCondition c) {
		//logdebug("Query vehicles, currently return all vehicles.");
		ArrayList<VehicleInfo> as = new ArrayList<VehicleInfo>();
		Iterator<VehicleStatus> iter = hmVehicles_.values().iterator();
		while (iter.hasNext()) {
			VehicleStatus vs = iter.next();
			as.add(vs.info);
		}
		VehicleInfo[] vi = new VehicleInfo[as.size()];
		return  as.toArray(vi);
	}

    public String registerStation(StationInfo info) {
    	Random rand = new Random();
    	do {
    		info.ID = "S" + rand.nextInt(9999);
    	} while(hmStations_.containsKey(info.ID));
    		
    	StationStatus ss = new StationStatus();
    	ss.info = info;
    	ss.open = false;
    	ss.batteries = new HashSet<String>();
    	hmStations_.put(info.ID, ss);
    	logdebug("Register station : " + info.ID);
    	return info.ID;
    }
    

    public void unregisterStation(String stationID) {    }
    public void setStation(String stationID, StationInfo info) { }
    
    public String registerDepot(DepotInfo info) { 
    	Random rand = new Random();
    	do {
    		info.ID = "D" + rand.nextInt(9999);
    	} while(hmStations_.containsKey(info.ID));
    		
    	DepotStatus ds = new DepotStatus();
    	ds.info = info;
    	ds.open = false;
    	ds.batteries = new HashSet<String>();
    	hmDepots_.put(info.ID, ds);
    	logdebug("Register depot : " + info.ID);
    	return info.ID;
   	}
    
    public void unregisterDepot(String depotID) { }
    public void setDepot(String depotID, DepotInfo info) { }
    
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

package autoflash.rpc;


import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.DepotQueryCondition;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

public class Server extends autoflash.rpc.slice._ClientServiceDisp {
	private MockCoreService service;

	Server() {
		service = new MockCoreService();
	}
	
	void log(String format, Object... args) {
		System.out.printf(format, args);
	}

	/**
	 * For Power Station
	 */
	// The amount may differ from the data in the database for storage wastage,
	// and need to be measured in station.
	public double rentBattery(int stationID, int vehicleID, int batteryID, double amount, Ice.Current current) {		
		log("Server: In station[%d], vehicle[%d] rent battery[%d][%f].\n", stationID, vehicleID, batteryID, amount);
		return service.rentBattery(stationID, vehicleID, batteryID, amount);
	}

	// The remaining amount is measured in station.
	public double returnBattery(int stationID, int vehicleID, int batteryID, double amount, Ice.Current current) {
		log("Server: In station[%d], vehicle[%d] return battery[%d][%f].\n", stationID, vehicleID, batteryID, amount);
		return service.returnBattery(stationID, vehicleID, batteryID, amount);
	}

	// Move battery, return the battery information.
	public BatteryInfo moveBatteryToStation(int stationID, int batteryID, Ice.Current current) {
		log("Server: Move battery[%d] to station[%d].\n", batteryID, stationID);
		return service.moveBatteryFromStation(stationID, batteryID);
	}

	public BatteryInfo moveBatteryFromStation(int stationID, int batteryID, Ice.Current current) {
		log("Server: Move battery[%d] from station[%d].\n", batteryID, stationID);
		return service.moveBatteryFromStation(stationID, batteryID);
	}

	// Report damaged battery.
	public void reportDamagedBattery(int stationID, int batteryID, Ice.Current current) {
		log("Server: Report damaged battery[%d] from station[%d].\n", batteryID, stationID);
		service.reportDamagedBattery(stationID, batteryID);
	}

	// For a car first change battery, register, return vehicle ID.
	public int registerVehicle(int stationID, VehicleInfo info, Ice.Current current) {
		log("Server: Register new vehicle in station[%d].\n", stationID);
		return service.registerVehicle(stationID, info);
	}

	public void openStation(int stationID, Ice.Current current) {
		log("Server: Station[%d] opens.\n", stationID);
		service.openStation(stationID);
	}

	public void closeStation(int stationID, Ice.Current current) {
		log("Server: Station[%d] closes.\n", stationID);
		service.closeStation(stationID);
	}

	/**
	 * For Depot
	 */
	// Move battery, return the battery information.
	public BatteryInfo moveBatteryToDepot(int depotID, int batteryID, Ice.Current current) {
		log("Server: Move battery[%d] from depot[%d].\n", batteryID, depotID);
		return service.moveBatteryToDepot(depotID, batteryID);
	}

	public BatteryInfo moveBatteryFromDepot(int depotID, int batteryID, Ice.Current current) {
		log("Server: Move battery[%d] from depot[%d].\n", batteryID, depotID);
		return service.moveBatteryFromDepot(depotID, batteryID);
	}

	// Charge battery.
	// The currentAmount record the current electricity amount of the battery.
	// The useAmount record the electricity amount used for change since last
	// report.
	public void charge(int depotID, int batteryID, double currentAmount, double useAmount, Ice.Current current) {
		log("Server: In depot[%d] charge battery[%d].\n", depotID, batteryID);
		service.charge(depotID, batteryID, currentAmount, useAmount);
	}

	// To discard a battery.
	public void discard(int depotID, int batteryID, Ice.Current current) {
		log("Server: In depot[%d] discard battery[%d].\n", depotID, batteryID);
		service.discard(depotID, batteryID);
	}

	public void openDepot(int depotID, Ice.Current current) {
		log("Server: Depot[%d] opens.\n", depotID);
		service.openDepot(depotID);
	}

	public void closeDepot(int depotID, Ice.Current current) {
		log("Server: Depot[%d] closes.\n", depotID);
		service.closeDepot(depotID);
	}

	/** For battery supplier */
	// For battery suppler to purchase a new battery.
	public void purchase(BatteryInfo info, Ice.Current current) {
		log("Server: purchase battery[%d].\n", info.ID);
		service.purchase(info);
	}

	/** For administrator */
	// Use integer value to represent time
	public Activity[] queryActivities(int start, int end, Ice.Current current) {
		log("Server: Query activies.\n");
		return service.queryActivities(start, end);
	}

	public Activity[] queryBatteryActivities(int batteryID, int start, int end, Ice.Current current) {
		log("Server: Query battery activies.\n");
		return service.queryBatteryActivities(batteryID, start, end);
	}

	public Activity[] queryStationActivities(int staionID, int start, int end, Ice.Current current) {
		log("Server: Query station activies.\n");
		return service.queryStationActivities(staionID, start, end);
	}

	public Activity[] queryDepotActivities(int staionID, int start, int end, Ice.Current current) {
		log("Server: Query depot activies.\n");
		return service.queryDepotActivities(staionID, start, end);
	}

	public StationInfo[] queryStations(StationQueryCondition c, Ice.Current current) {
		log("Server: Query stations.\n");
		return service.queryStations(c);
	}

	public DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current current) {
		log("Server: Query depots.\n");
		return service.queryDepots(c);
	}

	public BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current current) {
		log("Server: Query batteries.\n");
		return service.queryBatteries(c);
	}

	public VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current current) {
		log("Server: Query vehicles.\n");
		return service.queryVehicles(c);
	}

	// After registration, return the ID assigned
	public int registerStation(StationInfo info, Ice.Current current) {
		log("Server: Register station[%d].\n", info.ID);
		return service.registerStation(info);
	}

	public int registerDepot(DepotInfo info, Ice.Current current) {
		log("Server: Register depot[%d].\n", info.ID);
		return service.registerDepot(info);
	}

	public void unregisterStation(int stationID, Ice.Current current) {
		log("Server: Unregister station[%d].\n", stationID);
		service.unregisterStation(stationID);
	}

	public void setStation(int stationID, StationInfo info, Ice.Current current) {
		log("Server: Set station[%d].\n", stationID);
		service.setStation(stationID, info);
	}

	public void unregisterDepot(int depotID, Ice.Current current) {
		log("Server: Unregister station[%d].\n", depotID);
		service.unregisterDepot(depotID);
	}

	public void setDepot(int depotID, DepotInfo info, Ice.Current current) {
		log("Server: Set depot[%d].\n", depotID);
		service.setDepot(depotID, info);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server started.");
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("ClientServiceAdapter", "default -p 16000");
			Ice.Object object = new Server();
			adapter.add(object, ic.stringToIdentity("ClientService"));
			adapter.activate();
			System.out.println("ClientService started.");
			ic.waitForShutdown();
		} catch (Exception e) {
			e.printStackTrace();
			status = 1;
		}
		if (ic != null) {
			// Clean up
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}
}

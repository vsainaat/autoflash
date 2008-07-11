package autoflash.rpc;

import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.VehicleInfo;

/**
 * 这个类是用于向Station客户端提供服务的接口。
 * 
 * @author Kevin
 * 
 */
public class StationService {

	private autoflash.rpc.slice.ClientServicePrx service_;

	private MockService mservice_;

	public StationService() {
		service_ = ClientProxy.service();
		mservice_ = new MockService();
	}

	void log(String format, Object... args) {
		System.out.printf("StationService: " + format, args);
	}

	public double rentBattery(int stationID, int vehicleID, int batteryID, double amount) {
		log("In station[%d], vehicle[%d] rent battery[%d][%f].\n", stationID, vehicleID, batteryID, amount);
		return service_.rentBattery(stationID, vehicleID, batteryID, amount);
	}

	public double returnBattery(int stationID, int vehicleID, int batteryID, double amount) {
		log("In station[%d], vehicle[%d] return battery[%d][%f].\n", stationID, vehicleID, batteryID, amount);
		return service_.returnBattery(stationID, vehicleID, batteryID, amount);
	}

	public BatteryInfo moveBatteryToStation(int stationID, int batteryID) {
		log("Move battery[%d] to station[%d].\n", batteryID, stationID);
		return service_.moveBatteryFromStation(stationID, batteryID);
	}

	public BatteryInfo moveBatteryFromStation(int stationID, int batteryID) {
		log("Move battery[%d] from station[%d].\n", batteryID, stationID);
		return service_.moveBatteryFromStation(stationID, batteryID);
	}

	// Report damaged battery.
	public void reportDamagedBattery(int stationID, int batteryID) {
		log("Report damaged battery[%d] from station[%d].\n", batteryID, stationID);
		service_.reportDamagedBattery(stationID, batteryID);
	}

	// Register a mock vehicle, using MockService::registerMockVehicle
	public VehicleInfo registerMockVehicle(int stationID) {
		log("In station[%d], register new vehicle.\n", stationID);
		return mservice_.registerMockVehicle(stationID);
	}

	public int registerVehicle(int stationID, VehicleInfo info) {
		log("Register new vehicle in station[%d].\n", stationID);
		return service_.registerVehicle(stationID, info);
	}

	public void openStation(int stationID) {
		log("Station[%d] opens.\n", stationID);
		service_.openStation(stationID);
	}

	public void closeStation(int stationID) {
		log("Station[%d] closes.\n", stationID);
		service_.closeStation(stationID);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StationService ss = new StationService();
		StationInfo info = ss.mservice_.registerMockStation();
		int stationID = info.ID;
		System.out.printf("New Station %d. \n", stationID);
		ss.openStation(stationID);
		VehicleInfo vinfo = ss.registerMockVehicle(stationID);
		int vehicleInfo = vinfo.ID;
		ss.rentBattery(stationID, vehicleInfo, 12345, 10.0);
		ss.closeStation(info.ID);
	}

}

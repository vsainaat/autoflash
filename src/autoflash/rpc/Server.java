/**
 * Server类是服务器端运行的最底层的类，这里的main函数也就是服务器端的最底层入口。
 * Server类的主要作用有两点：
 * 	1.实现ClientService服务的各个接口，这主要通过调用CoreService来完成，调试时暂时使用MockCoreService来模拟。
 * 	2.main函数用于启动Ice服务，响应客户端的请求。
 */
package autoflash.rpc;

import java.io.IOException;
import java.util.Formatter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import Ice.Current;
import autoflash.rpc.slice.Activity;
import autoflash.rpc.slice.BatteryInfo;
import autoflash.rpc.slice.BatteryQueryCondition;
import autoflash.rpc.slice.DepotInfo;
import autoflash.rpc.slice.DepotQueryCondition;
import autoflash.rpc.slice.OperationError;
import autoflash.rpc.slice.StationInfo;
import autoflash.rpc.slice.StationQueryCondition;
import autoflash.rpc.slice.VehicleInfo;
import autoflash.rpc.slice.VehicleQueryCondition;

public class Server extends autoflash.rpc.slice._ClientServiceDisp {
	Server() throws IOException {
		service_ = new MockCoreService();
	}
	

	/**
	 * For Power Station
	 * @throws OperationError 
	 */
	public double rentBattery(String stationID, String vehicleID, String batteryID, double amount, Ice.Current current) throws OperationError {		
		log("Station[%s], vehicle[%s] rent battery[%s][%f].", stationID, vehicleID, batteryID, amount);
		return service_.rentBattery(stationID, vehicleID, batteryID, amount);
	}

	public double returnBattery(String stationID, String vehicleID, String batteryID, double amount, Ice.Current current) throws OperationError {
		log("Station[%s], vehicle[%s] return battery[%s][%f].", stationID, vehicleID, batteryID, amount);
		return service_.returnBattery(stationID, vehicleID, batteryID, amount);
	}

	public void moveBatteryToStation(String stationID, String batteryID, Ice.Current current) throws OperationError {
		log("Station[%s], move in battery[%s].", stationID, batteryID);
		service_.moveBatteryToStation(stationID, batteryID);
	}

	public void moveBatteryFromStation(String stationID, String batteryID, Ice.Current current) throws OperationError {
		log("Station[%s], move out battery[%s].", stationID, batteryID);
		service_.moveBatteryFromStation(stationID, batteryID);
	}

	public void reportDamagedBattery(String stationID, String batteryID, Ice.Current current) throws OperationError {
		log("Station[%s], report damaged battery[%s].", stationID, batteryID);
		service_.reportDamagedBattery(stationID, batteryID);
	}

	public String registerVehicle(String stationID, VehicleInfo info, Ice.Current current) throws OperationError {
		log("Station[%s], register new vehicle.", stationID);
		return service_.registerVehicle(stationID, info);
	}

	public void openStation(String stationID, Ice.Current current) {
		log("Station[%s] opens.", stationID);
		service_.openStation(stationID);
	}

	public void closeStation(String stationID, Ice.Current current) {
		log("Station[%s] closes.", stationID);
		service_.closeStation(stationID);
	}

	/**
	 * For Depot
	 * @throws OperationError 
	 */
	public void moveBatteryToDepot(String depotID, String batteryID, Ice.Current current) throws OperationError {
		log("Depot[%s], move in battery[%s].", depotID, batteryID);
		service_.moveBatteryToDepot(depotID, batteryID);
	}

	public void moveBatteryFromDepot(String depotID, String batteryID, Ice.Current current) throws OperationError {
		log("Depot[%s], move out battery[%s].", depotID, batteryID);
		service_.moveBatteryFromDepot(depotID, batteryID);
	}

	public void charge(String depotID, String batteryID, double currentAmount, double useAmount, Ice.Current current) throws OperationError {
		log("Depot[%s] charge battery[%s].", depotID, batteryID);
		service_.charge(depotID, batteryID, currentAmount, useAmount);
	}

	public void discard(String depotID, String batteryID, Ice.Current current) throws OperationError {
		log("Depot[%s] discard battery[%s].", depotID, batteryID);
		service_.discard(depotID, batteryID);
	}

	public void openDepot(String depotID, Ice.Current current) {
		log("Depot[%s] opens.", depotID);
		service_.openDepot(depotID);
	}

	public void closeDepot(String depotID, Ice.Current current) {
		log("Depot[%s] closes.", depotID);
		service_.closeDepot(depotID);
	}

	/** For battery supplier */
	public String purchase(BatteryInfo info, double price, Ice.Current current) {
		log("Purchase new battery, cost " + price);
		return service_.purchase(info, price);
	}

	/** For administrator */
	public Activity[] queryActivities(long start, long end, Ice.Current current) {
		log("Query activies.");
		return service_.queryActivities(start, end);
	}

	public Activity[] queryBatteryActivities(String batteryID, long start, long end, Ice.Current current) {
		log("Query battery activies.");
		return service_.queryBatteryActivities(batteryID, start, end);
	}

	public Activity[] queryStationActivities(String stationID, long start, long end, Ice.Current current) {
		log("Query station activies.");
		return service_.queryStationActivities(stationID, start, end);
	}

	public Activity[] queryDepotActivities(String stationID, long start, long end, Ice.Current current) {
		log("Query depot activies.");
		return service_.queryDepotActivities(stationID, start, end);
	}

	public StationInfo[] queryStations(StationQueryCondition c, Ice.Current current) {
		log("Query stations.");
		return service_.queryStations(c);
	}

	public DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current current) {
		log("Query depots.");
		return service_.queryDepots(c);
	}

	public BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current current) {
		log("Query batteries.");
		return service_.queryBatteries(c);
	}

	public VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current current) {
		log("Query vehicles.");
		return service_.queryVehicles(c);
	}

	public String registerStation(StationInfo info, Ice.Current current) {
		log("Register station.");
		return service_.registerStation(info);
	}

	public String registerDepot(DepotInfo info, Ice.Current current) {
		log("Register depot.");
		return service_.registerDepot(info);
	}

	public void unregisterStation(String stationID, Ice.Current current) throws OperationError {
		log("Unregister station[%s].", stationID);
		service_.unregisterStation(stationID);
	}

	public void setStation(String stationID, StationInfo info, Ice.Current current) throws OperationError {
		log("Set station[%s].", stationID);
		service_.setStation(stationID, info);
	}

	public void unregisterDepot(String depotID, Ice.Current current) throws OperationError {
		log("Unregister station[%s].", depotID);
		service_.unregisterDepot(depotID);
	}

	public void setDepot(String depotID, DepotInfo info, Ice.Current current) throws OperationError {
		log("Set depot[%s].", depotID);
		service_.setDepot(depotID, info);
	}
	
	public void setUnitChargePrice(double price, Current __current) {
		log("Set unit charge price to " + price);
	}

	public void setUnitPrice(double price, Current __current) {
		log("Set unit charge price to " + price);
	}
	
	//记日志，同时在屏幕输出并记入文件
	static void log(String format, Object... args) {
		logger.info(new Formatter().format(format, args));
	}

	static private Logger logger = Logger.getLogger("autoflash Server");
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

	private MockCoreService service_;

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
			logger.fatal("Catch Exception:", e);
			status = 1;
		}
		if (ic != null) {
			// Clean up
			try {
				ic.destroy();
			} catch (Exception e) {
				logger.fatal("Catch Exception:", e);
				status = 1;
			}
		}
		System.exit(status);
	}




}

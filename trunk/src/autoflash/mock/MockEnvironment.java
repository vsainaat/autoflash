package autoflash.mock;

import autoflash.rpc.ClientProxy;
import autoflash.rpc.MockService;

import java.io.IOException;
import java.util.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import autoflash.rpc.slice.*;

/**
 * 模拟一个应用场景，我们保证有多个加电站、多部车辆和多个电池，并保证至少有一个充电站。
 */
public class MockEnvironment {

	// 子类MockTransfer模拟电池在加电站和充电站之间的流动， 目前不考虑加电站和充电站的存储容量。
	static class MockTransfer extends Thread {

		// 不断检查各个加电站，只要有空电池就运到充电站充电站充电。
		// 不断检查各个充电站，只要有充满的电池就运到各个加电站。
		public void run() {
			try {
				log("MockTransfer starts.");
				StationInfo[] ssinfo = MockService.queryAllStations();
				DepotInfo dinfo = MockService.queryAllDepots()[0];

				BatteryQueryCondition c = MockService.makeQueryAllBatteryCondition();

				while (true) {
					// log("MockTransfer checks.");
					// 寻找各个加电站中换下来的空电池并运送到充电站充电。
					for (StationInfo si : ssinfo) {
						c.state = BatteryState.Empty;
						c.stationID = si.ID;
						c.depotID = "";
						BatteryInfo[] binfo = service_.queryBatteries(c);
						for (BatteryInfo bi : binfo) {
							log("MockTransfer charge battery[%s] in station[%s].", bi.ID, si.ID);
							service_.moveBatteryFromStation(si.ID, bi.ID);
							service_.moveBatteryToDepot(dinfo.ID, bi.ID);
							service_.charge(dinfo.ID, bi.ID, bi.model.capacity, bi.model.capacity);
						}
					}
					Thread.sleep(1000);

					// 寻找充电站中充满的电池，随机运送到各个加电站
					c.state = BatteryState.Charged;
					c.depotID = dinfo.ID;
					c.stationID = "";
					BatteryInfo[] binfo = service_.queryBatteries(c);
					for (BatteryInfo bi : binfo) {
						int sindex = rand_.nextInt(ssinfo.length);
						service_.moveBatteryFromDepot(dinfo.ID, bi.ID);
						service_.moveBatteryToStation(ssinfo[sindex].ID, bi.ID);
						log("MockTransfer supply battery[%s] to station[%s].", bi.ID, ssinfo[sindex].ID);
					}
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	} // class MockTransfer

	// 子类MockVehicle模拟一部车辆，随机进行换电池的操作
	static class MockVehicle extends Thread {
		private String vehicleID_; // 这部车辆的ID

		private String batteryID_ = ""; // 在车辆上的电池的ID，初始时为空

		private static Object obj = new Object();

		public MockVehicle(String ID) {
			vehicleID_ = ID;
		}

		// 更换电池
		public void changeBattery(StationInfo[] ss) throws OperationError {
			int sindex = rand_.nextInt(ss.length);
			BatteryQueryCondition c = MockService.makeQueryAllBatteryCondition();
			c.stationID = ss[sindex].ID;
			c.state = BatteryState.Charged;
			synchronized (obj) {
				BatteryInfo[] binfo = service_.queryBatteries(c);
				if (binfo.length == 0) {
					log("Vehicle[%s] find no avaiable battery in station[%s].", vehicleID_, ss[sindex].ID);
					return;
				}
				double m = 0;
				if (batteryID_.length() > 0) {
					m += service_.returnBattery(ss[sindex].ID, vehicleID_, batteryID_, rand_.nextDouble() * 30.0);
				}
				m += service_.rentBattery(ss[sindex].ID, vehicleID_, binfo[0].ID, binfo[0].model.capacity);
				log("Vehicle[%s] change battery[%s -> %s] in station[%s], pay %f.", vehicleID_, batteryID_,
						binfo[0].ID, ss[sindex].ID, m);
				batteryID_ = binfo[0].ID;
			}
		}

		// 随机间隔一段时间后更换电池
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(10000));
				log("Mock Vehicle[%s] starts.", vehicleID_);
				StationInfo[] ss = MockService.queryAllStations();
				while (true) {
					Thread.sleep(new Random().nextInt(10000) + 5000);
					changeBattery(ss);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	} // class MockVehicle

	// 运行模拟环境，首先为环境添加足够的加电站、充电站、车辆、电池，然后启动模拟运输和模拟车辆。
	void mock() throws OperationError {
		StationInfo[] sinfo = MockService.queryAllStations();
		VehicleInfo[] vinfo = MockService.queryAllVehicles();
		DepotInfo[] dinfo = MockService.queryAllDepots();
		BatteryInfo[] binfo = MockService.queryAllBatteries();

		// 确保一定数量的加电站数目
		final int MIN_STATION_NUM = 10;
		if (sinfo.length < MIN_STATION_NUM) {
			log("Register " + MIN_STATION_NUM + " stations.");
			for (int i = 0; i < MIN_STATION_NUM; ++i) {
				service_.registerStation(MockService.makeMockStation());
			}
			sinfo = MockService.queryAllStations();
		}

		// 确保至少有一个充电站，暂时认为充电站的容量无限，且充电时间可忽略不计
		if (dinfo.length < 1) {
			log("Register 1 depot.");
			service_.registerDepot(MockService.makeMockDepot());
			dinfo = MockService.queryAllDepots();
		}

		// 开放所有的加电站和充电站
		for (StationInfo info : sinfo)
			service_.openStation(info.ID);
		for (DepotInfo info : dinfo)
			service_.openDepot(info.ID);

		// 确保一定数量的车辆数目
		final int MIN_VEHICLE_NUM = 100;
		if (vinfo.length < MIN_VEHICLE_NUM) {
			log("Register " + MIN_VEHICLE_NUM + " vehicles.");
			for (int i = 0; i < MIN_VEHICLE_NUM; ++i) {
				service_.registerVehicle(sinfo[i % sinfo.length].ID, MockService.makeMockVehicle());
			}
			vinfo = MockService.queryAllVehicles();
		}

		// 确保一定数目的电池数目
		int MIN_BATTERY_NUM = 300;
		if (binfo.length < MIN_BATTERY_NUM) {
			log("Purchase " + MIN_BATTERY_NUM + " batteries.");
			for (int i = 0; i < MIN_BATTERY_NUM; ++i) {
				String batteryID = service_.purchase(MockService.makeMockBattery(), 10000);
				service_.moveBatteryToDepot(dinfo[0].ID, batteryID);
				service_.charge(dinfo[0].ID, batteryID, 100, 100);
			}
			vinfo = MockService.queryAllVehicles();
		}

		log("Start mock environment.");
		new MockTransfer().start();
		for (int i = 0; i < vinfo.length; ++i)
			new MockVehicle(vinfo[i].ID).start();
	}

	// 记日志，同时在屏幕输出并记入文件
	static void log(String format, Object... args) {
		logger.info(new Formatter().format(format, args));
	}

	static Logger logger = Logger.getLogger("MockEnvironment");
	static {
		Layout layout = new PatternLayout("%d [%c] %p - %m\n");
		logger.addAppender(new ConsoleAppender(layout));
		DailyRollingFileAppender rfa = null;
		try {
			rfa = new DailyRollingFileAppender(layout, "autoflash_mockenv.log", ".yyyy-MM-dd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.fatal("Catch exception when initialzing logger:", e);
			System.exit(1);
		}
		logger.addAppender(rfa);
	}

	static private autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();
	static private Random rand_ = new Random();

	/**
	 * @param args
	 * @throws OperationError 
	 */
	public static void main(String[] args) throws OperationError {
		// TODO Auto-generated method stub
		(new MockEnvironment()).mock();
	}

}

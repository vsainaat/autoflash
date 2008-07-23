package autoflash.rpc;

import java.util.Random;
import java.util.Date;

import autoflash.rpc.slice.*;

/**
 * MockService类用于提供一些模拟的函数，比如随机生成加电站或车辆的信息，，以及简化了一些常用的查询，
 * 主要用于MockEnviroment，也可用于各个客户端。
 */

public class MockService {
	// 随机生成电池信息
	public static BatteryInfo makeMockBattery() {
		BatteryModel bm = new BatteryModel();
		bm.capacity = 100.0;
		bm.factory = "Sony";
		bm.maxChargeRounds = 1000;
		bm.maxLifeTime = 2000;
		bm.name = "CB1";

		BatteryInfo b = new BatteryInfo();
		b.shippedDate = (int) (new Date().getTime() / 3600 / 24);
		b.model = bm;
		return b;
	}

	// 随机生成地图上的一个点，坐标值位于(-999, -999) - (999, 999)
	public static Point makeMockPoint() {
		Point p = new Point();
		p.latitude = rand_.nextInt() % 1000;
		p.longitude = rand_.nextInt() % 1000;
		return p;
	}

	// 随机生成地图上的一个区域，坐标值位于(-999, -999) - (1998, 1998) 之间
	public static Area makeMockArea() {
		Area a = new Area();
		a.topLeftCorner = makeMockPoint();
		a.latitudeSpan = rand_.nextInt(1000);
		a.longitudeSpan = rand_.nextInt(1000);
		return a;
	}

	// 随机生成一个加电站的信息。
	public static StationInfo makeMockStation() {
		StationInfo info = new StationInfo();
		info.position = makeMockPoint();
		info.address = "Latitude[" + info.position.latitude + "] Longitude[" + info.position.latitude + "]";
		info.capacity = rand_.nextInt(99999) + 30000;
		info.chargePrice = 10.0;
		info.owner = "autoflash";
		info.rentPrice = rand_.nextInt(99) + 10;
		info.ID = "unknown";
		return info;
	}

	// 随机生成一个充电站的信息
	public static DepotInfo makeMockDepot() {
		DepotInfo info = new DepotInfo();
		info.position = makeMockPoint();
		info.address = "Latitude[" + info.position.latitude + "] Longitude[" + info.position.latitude + "]";
		info.chargeCapacity = rand_.nextInt(9999) + 3000;
		info.chargePrice = 10.0;
		info.owner = "autoflash";
		info.rentPrice = rand_.nextInt(99) + 10;
		info.storageCapacity = info.chargeCapacity * 10;
		info.ID = "unknown";
		return info;
	}

	// 随机生成车辆信息
	public static VehicleInfo makeMockVehicle() {
		VehicleInfo info = new VehicleInfo();
		info.model = "benz";
		info.licence = ((Integer) (rand_.nextInt(888888) + 111111)).toString();
		info.ID = "unknown";
		return info;
	}

	// 获取所有的加电站。
	public static StationInfo[] queryAllStations() {
		StationQueryCondition c = new StationQueryCondition();
		c.region = new Area();
		c.region.topLeftCorner = new Point();
		c.region.topLeftCorner.latitude = -9999;
		c.region.topLeftCorner.longitude = -9999;
		c.region.latitudeSpan = 9999 * 2;
		c.region.longitudeSpan = 9999 * 2;
		c.maxCapacity = -1;
		c.minCapacity = -1;
		c.owner = "";
		c.stationID = "";
		c.status = OpenStatus.OpenOrClosed;
		return service_.queryStations(c);
	}

	// 获取所有的车辆
	public static VehicleInfo[] queryAllVehicles() {
		VehicleQueryCondition c = new VehicleQueryCondition();
		c.minChargeDate = 0;
		c.maxChargeDate = 99999;
		c.batteryNum = -1;
		c.model = "";
		c.batteryID = "";
		return service_.queryVehicles(c);
	}

	// 获取所有的充电站
	public static DepotInfo[] queryAllDepots() {
		DepotQueryCondition c = new DepotQueryCondition();
		c.region = new Area();
		c.region.topLeftCorner = new Point();
		c.region.topLeftCorner.latitude = -9999;
		c.region.topLeftCorner.longitude = -9999;
		c.region.latitudeSpan = 9999 * 2;
		c.region.longitudeSpan = 9999 * 2;
		c.maxChargeCapacity = -1;
		c.minChargeCapacity = -1;
		c.minChargeCapacity = -1;
		c.maxChargeCapacity = -1;
		c.owner = "";
		c.depotID = "";
		c.status = OpenStatus.OpenOrClosed;
		return service_.queryDepots(c);
	}

	// 获取所有的电池
	public static BatteryInfo[] queryAllBatteries() {
		return service_.queryBatteries(makeQueryAllBatteryCondition());
	}
	
	// 生成获取任意电池的查询条件
	public static BatteryQueryCondition makeQueryAllBatteryCondition(){
		BatteryQueryCondition c = new BatteryQueryCondition();
		c.model = new BatteryModel();
		c.model.name = "";
		c.maxChargeRounds = -1;
		c.depotID = "";
		c.maxShippedDate = 99999;
		c.minChargeRounds = -1;
		c.minShippedDate = 0;
		c.stationID = "";
		c.state = BatteryState.Arbitrary;
		c.vehicleID = "";
		return c;
	}

	private static autoflash.rpc.slice.ClientServicePrx service_ = ClientProxy.service();

	private static Random rand_ = new Random();

}

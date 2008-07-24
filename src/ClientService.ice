#include <Exceptions.ice>
module autoflash {
module rpc {
module slice{

    struct Point {
        int latitude;
        int longitude;
    };
    
    struct Area {
    	Point topLeftCorner;
    	int latitudeSpan;
    	int longitudeSpan;
    };

	// 电池型号
    struct BatteryModel {
        string name;
        int maxChargeRounds;	// 最多充电次数
        double capacity;		// 容量
        int maxLifeTime;		// 最长生命周期，以日计算
        string factory;
    };

    struct BatteryInfo {	
        string ID;
        BatteryModel model;
        int shippedDate;		// 购买日期
        int chargeRounds;		// 已充电次数
    };
    sequence<BatteryInfo> BatteriesInfo;

    struct StationInfo {
        string ID;
        string address;
        Point position; 
        int capacity;			// 可存储的电池数
        string owner;
        double chargePrice;		// 充电价格，暂时不用于计价
        double rentPrice;		// 场地租金
    };
    sequence<StationInfo> StationsInfo;

    struct DepotInfo {
        string ID;
        string address;
		Point position;
        double chargePrice;		// 充电价格
        int storageCapacity;	// 可存储的电池数
        int chargeCapacity;		// 可同时充电的电池数
        string owner;
        double rentPrice;		// 场地租金
    };
    sequence<DepotInfo> DepotsInfo;

    struct VehicleInfo {
        string ID;				// 考虑到某些车辆可能没有车牌（如新车），因此使用ID统一标示车辆
		string licence;			// 车牌号
        string owner;
        string model;
    };
    sequence<VehicleInfo> VehiclesInfo;

    enum BatteryState {Empty, 		// 位于加电站或充电站，处于需要充电的状态
    					Charging, 	// 正在充电
    					Charged, 	// 已充电完毕
    					Onboard, 	// 已被租出，位于车辆上
    					Discarded, 	// 已经废弃
    					Arbitrary 
    					};
    					
    enum OpenStatus { Open, Closed, OpenOrClosed };

	// 在以下的充电条件中，一些条件可忽略，比如对于代表ID的string，空串表明忽略此条件。
    struct BatteryQueryCondition {
        BatteryModel model;		// 查询特定型号的电池
        BatteryState state;		// 查询特定状态的电池
        int minShippedDate;		// 查询迟于特定日期购买的电池
        int maxShippedDate;		// 查询早于特定日期购买的电池
        int minChargeRounds;	// 查询充电次数大于特定值的电池
        int maxChargeRounds;	// 查询充电次数小于特定值的电池
        string stationID;  		// 查询目前位于某加电站内的电池
        string depotID;    		// 查询目前位于某充电站内的电池
        string vehicleID;  		// 查询目前位于某个车辆上的电池
    };

    struct StationQueryCondition {
        Area region;			// 查询位于某个区域内的站点
        string stationID;  		// 查询具有特定ID的站点
        OpenStatus status;		// 查询目前开放或关闭的站点
        string owner;			// 查询特定拥有人的站点
        int minCapacity;		// 查询容量大于特定值的站点
        int maxCapacity;		// 查询容量小于特定值的站点
    };
    struct DepotQueryCondition {
        Area region;			// 查询位于某个区域内的站点
        string depotID;    		// 查询具有特定ID的站点
        OpenStatus status;		// 查询目前开放或关闭的站点
        string owner;			// 查询特定拥有人的站点
        int minStorageCapacity;	// 查询存储容量大于特定值的站点
        int maxStorageCapacity;	// 查询存储容量小于特定值的站点
        int minChargeCapacity;	// 查询充电容量大于特定值的站点
        int maxChargeCapacity;	// 查询充电容量小于特定值的站点
    };
    struct VehicleQueryCondition {
        string model;			// 查询某个型号的车辆
        int minChargeDate;		// 查询上次加电不早于特定日期的车辆
        int maxChargeDate;		// 查询上次加电不晚于特定日期的车辆
        int batteryNum;			// 查询目前租用特定书目电池的车辆
        string batteryID;		// 查询目前某个电池所位于的车辆
    };
    
    enum ActivityType { Rent, Return, MoveFromStation, MoveToStation, MoveFromDepot, MoveToDepot, 
    					Purchase, Discard, OpenStation, CloseStation, OpenDepot, CloseDepot, 
    					Register, Unregister, Set, Charge };
    struct Activity {
    	long time;
        ActivityType type;
        string batteryID;
        string vehicleID;
        string stationOrDepotID;
        double price;
    };
    sequence<Activity> Activities;

    interface ClientService {
        /** For Power Station */
        // 大部分情况下应当是首先归还一块用过的电池并租借一块新电池，但也可以一次租借或归还多块电池，因此把两个操作分开。
        // 目前设计所有的计价操作都放在服务器端进行，因此客户端只需要提供相关信息并从服务器端得到操作价格。
        // rentBattery返回正值，returnBattery返回负值。
        double rentBattery(string stationID, string vehicleID, string batteryID, double amount)
        	throws OperationError;
        double returnBattery(string stationID, string vechildID, string batteryID, double amount)
        	throws OperationError;

        // 电池运入或运出加电站。
        // 我们暂时不考虑电池运输的安排的工作，只是进行记录。
        void moveBatteryToStation(string stationID, string batteryID) throws OperationError;
        void moveBatteryFromStation(string stationID, string batteryID) throws OperationError;

        // 报告失效的电池。
        // TODO: 考虑用户损坏的赔偿问题。
        void reportDamagedBattery(string stationID, string batteryID) throws OperationError;

        // 对于不在数据库的内的车辆，应当首先注册。注册时向服务器传入车辆信息，服务器生成车辆ID并返回。
        string registerVehicle(string stationID, VehicleInfo info) throws OperationError;

		// 开放或关闭一个加电站。
        void openStation(string stationID) throws OperationError;
        void closeStation(string stationID) throws OperationError;

        /** For Depot */
        // 电池运入或运出充电站。
        // 我们暂时不考虑电池运输的安排的工作，只是进行记录。
        void moveBatteryToDepot(string depotID, string batteryID) throws OperationError;
        void moveBatteryFromDepot(string depotID, string batteryID) throws OperationError;

 		// 为电池充电，向服务器报告电池充满电后目前的电量，以及这次充电的用电量。
        void charge(string depotID, string batteryID, double currentAmount, double useAmount) throws OperationError;

        // 废弃电池，包括报废的以及损坏的电池。
        void discard(string depotID, string batteryID) throws OperationError;

        void openDepot(string depotID) throws OperationError;
        void closeDepot(string depotID) throws OperationError;

        /** For battery supplier */
        // 采购新电池，返回新电池的ID
        string purchase(BatteryInfo info, double price) throws OperationError;

        /** For administrator */
        // 查询在特定时间段内的活动记录
        Activities queryActivities(long start, long end);
        Activities queryBatteryActivities(string batteryID, long start, long end) throws OperationError;
        Activities queryStationActivities(string staionID, long start, long end) throws OperationError;
        Activities queryDepotActivities(string staionID, long start, long end) throws OperationError;

		// 根据查询条件查询特定的站点或车辆、电池
        StationsInfo queryStations(StationQueryCondition c) throws OperationError;
        DepotsInfo queryDepots(DepotQueryCondition c) throws OperationError;
        BatteriesInfo queryBatteries(BatteryQueryCondition c) throws OperationError;
        VehiclesInfo queryVehicles(VehicleQueryCondition c) throws OperationError;

        // 注册加电站或充电站。注册时，传入站点信息后，服务器返回站点ID
        string registerStation(StationInfo info) throws OperationError;
        string registerDepot(DepotInfo info) throws OperationError;
        void unregisterStation(string stationID) throws OperationError;
        void setStation(string stationID, StationInfo info) throws OperationError;
        void unregisterDepot(string depotID) throws OperationError;
        void setDepot(string stationID, DepotInfo info) throws OperationError;
        
        // 设置系统属性
        //设置换电池的单位价格，暂时简单处理认为全局采用统一价格
        void setUnitPrice(double price) throws OperationError;			
        //设置充电的单位价格，暂时简单处理认为全局采用统一价格
        void setUnitChargePrice(double price) throws OperationError;		
    };  // interface ClientService
};	// module slice
};  // module rpc
};	// module autoflash

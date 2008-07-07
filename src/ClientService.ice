module rpc {

    struct Address {
        int x;
        int y;
    };

    struct Area {
        int xmin;
        int xmax;
        int ymin;
        int ymax;
    };

    struct BatteryModel {
        string name;
        int maxChargeRounds;
        double capacity;
        int maxLifeTime;
        string factory;
    };

    struct BatteryInfo {	
        int ID;
        BatteryModel model;
        int shippedDate;
        int chargeRounds;
    };
    sequence<BatteryInfo> BatteriesInfo;

    struct StationInfo {
        int ID;
        Address addr;
        int capacity;
        string owner;
        double chargePrice;
        int rentPrice;
    };
    sequence<StationInfo> StationsInfo;

    struct DepotInfo {
        int ID;
        Address addr;
        double chargePrice;
        int storageCapacity;
        int chargeCapacity;
        string owner;
        int rentPrice;
    };
    sequence<DepotInfo> DepotsInfo;

    struct VehicleInfo {
        int ID;
        string code;
        string model;
    };
    sequence<VehicleInfo> VehiclesInfo;

    enum BatteryStatus { Shipped, Storage, Charging, Onboard, Discarded, Arbitrary };

    struct BatteryQueryCondition {
        BatteryModel model;
        BatteryStatus status;
        int minShippedDate;
        int maxShippedDate;
        int minChargeRounds;
        int maxChargeRounds;
        int stationID;  // There is certain value to indicate ignoring this item;
        int depotID;    // There is certain value to indicate ignoring this item;
        int vehicleID;  // There is certain value to indicate ignoring this item;
    };

    struct StationQueryCondition {
        Area addr;
        int stationID;  // There is certain value to indicate ignoring this item;
        bool open;
        string owner;
        int minCapacity;
        int maxCapacity;
    };
    struct DepotQueryCondition {
        Area addr;
        int depotID;    // There is certain value to indicate ignoring this item;
        bool open;
        string owner;
        int minStorageCapacity;
        int maxStorageCapacity;
        int minChargeCapacity;
        int maxChargeCapacity;
    };
    struct VehicleQueryCondition {
        string factory;
        int minChangeDate;
        int maxChangeDate;
        int batteryNum;
    };
    enum ActivityType { Rent, Return, MoveFromStation, MoveToStation, MoveFromDepot, MoveInDepot, Purchase, Discard, Open, Close, Register, Unregister, Set, Charge };
    struct Activity {
        ActivityType type;
        int batteryID;
        int stationOrDepotID;
        int money;
    };
    sequence<Activity> Activities;

    interface ClientService {
        /** For Power Station */
        // The amount may differ from the data in the database, and need to be measured in station.
        double rentBattery(int stationID, int vehicleID, int batteryID, double amount);
        // The remaining amount is measured in station.
        double returnBattery(int stationID, int vechildID, int batteryID, double amount);

        // Move battery, return the battery information.
        BatteryInfo moveBatteryToStation(int stationID, int batteryID);
        BatteryInfo moveBatteryFromStation(int stationID, int batteryID);

        // Report damaged battery.
        void reportDamagedBattery(int stationID, int batteryID);

        // For a car first change battery, register, return vehicle ID.
        int registerVehicle(int stationID, VehicleInfo info);

        void openStation(int stationID);
        void closeStation(int stationID);

        /** For Depot */
        // Move battery, return the battery information.
        BatteryInfo moveBatteryToDepot(int depotID, int batteryID);
        BatteryInfo moveBatteryFromDepot(int depotID, int batteryID);

        // Charge battery.
        // The currentAmount record the current electricity amount of the battery.
        // The useAmount record the electricity amount used for change since last report.
        void charge(int stationID, int batteryID, double currentAmount, double useAmount);

        // To discard a battery.
        void discard(int BatteryID);

        void openDepot(int depotID);
        void closeDepot(int depotID);

        /** For battery supplier */
        // For battery suppler to purchase a new battery.
        void purchase(BatteryInfo info);

        /** For administrator */
        // Use integer value to represent time
        Activities queryActivities(int start, int end);
        Activities queryBatteryActivities(int batteryID, int start, int end);
        Activities queryStationActivities(int staionID, int start, int end);
        Activities queryDepotActivities(int staionID, int start, int end);

        StationsInfo queryStations(StationQueryCondition c);
        DepotsInfo queryDepots(DepotQueryCondition c);
        BatteriesInfo queryBatteries(BatteryQueryCondition c);
        VehiclesInfo queryVehicles(VehicleQueryCondition c);

        // After registration, return the ID assigned
        int registerStation(StationInfo info);
        int registerDepot(DepotInfo info);
        void unregisterStation(int stationID);
        void setStation(int stationID, StationInfo info);
        void unregisterDepot(DepotInfo info);
        void setDepot(int stationID, DepotInfo info);
    };  // interface ClientService
};  // module rpc

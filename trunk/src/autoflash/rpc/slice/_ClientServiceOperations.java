// **********************************************************************
//
// Copyright (c) 2003-2007 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.2.1

package autoflash.rpc.slice;

public interface _ClientServiceOperations
{
    double rentBattery(String stationID, String vehicleID, String batteryID, double amount, Ice.Current __current);

    double returnBattery(String stationID, String vechildID, String batteryID, double amount, Ice.Current __current);

    void moveBatteryToStation(String stationID, String batteryID, Ice.Current __current);

    void moveBatteryFromStation(String stationID, String batteryID, Ice.Current __current);

    void reportDamagedBattery(String stationID, String batteryID, Ice.Current __current);

    String registerVehicle(String stationID, VehicleInfo info, Ice.Current __current);

    void openStation(String stationID, Ice.Current __current);

    void closeStation(String stationID, Ice.Current __current);

    void moveBatteryToDepot(String depotID, String batteryID, Ice.Current __current);

    void moveBatteryFromDepot(String depotID, String batteryID, Ice.Current __current);

    void charge(String depotID, String batteryID, double currentAmount, double useAmount, Ice.Current __current);

    void discard(String depotID, String batteryID, Ice.Current __current);

    void openDepot(String depotID, Ice.Current __current);

    void closeDepot(String depotID, Ice.Current __current);

    String purchase(BatteryInfo info, Ice.Current __current);

    Activity[] queryActivities(int start, int end, Ice.Current __current);

    Activity[] queryBatteryActivities(String batteryID, int start, int end, Ice.Current __current);

    Activity[] queryStationActivities(String staionID, int start, int end, Ice.Current __current);

    Activity[] queryDepotActivities(String staionID, int start, int end, Ice.Current __current);

    StationInfo[] queryStations(StationQueryCondition c, Ice.Current __current);

    DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current __current);

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current __current);

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current __current);

    String registerStation(StationInfo info, Ice.Current __current);

    String registerDepot(DepotInfo info, Ice.Current __current);

    void unregisterStation(String stationID, Ice.Current __current);

    void setStation(String stationID, StationInfo info, Ice.Current __current);

    void unregisterDepot(String depotID, Ice.Current __current);

    void setDepot(String stationID, DepotInfo info, Ice.Current __current);
}

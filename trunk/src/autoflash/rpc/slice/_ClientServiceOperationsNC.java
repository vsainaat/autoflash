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

public interface _ClientServiceOperationsNC
{
    double rentBattery(String stationID, String vehicleID, String batteryID, double amount);

    double returnBattery(String stationID, String vechildID, String batteryID, double amount);

    void moveBatteryToStation(String stationID, String batteryID);

    void moveBatteryFromStation(String stationID, String batteryID);

    void reportDamagedBattery(String stationID, String batteryID);

    String registerVehicle(String stationID, VehicleInfo info);

    void openStation(String stationID);

    void closeStation(String stationID);

    void moveBatteryToDepot(String depotID, String batteryID);

    void moveBatteryFromDepot(String depotID, String batteryID);

    void charge(String depotID, String batteryID, double currentAmount, double useAmount);

    void discard(String depotID, String batteryID);

    void openDepot(String depotID);

    void closeDepot(String depotID);

    String purchase(BatteryInfo info);

    Activity[] queryActivities(int start, int end);

    Activity[] queryBatteryActivities(String batteryID, int start, int end);

    Activity[] queryStationActivities(String staionID, int start, int end);

    Activity[] queryDepotActivities(String staionID, int start, int end);

    StationInfo[] queryStations(StationQueryCondition c);

    DepotInfo[] queryDepots(DepotQueryCondition c);

    BatteryInfo[] queryBatteries(BatteryQueryCondition c);

    VehicleInfo[] queryVehicles(VehicleQueryCondition c);

    String registerStation(StationInfo info);

    String registerDepot(DepotInfo info);

    void unregisterStation(String stationID);

    void setStation(String stationID, StationInfo info);

    void unregisterDepot(String depotID);

    void setDepot(String stationID, DepotInfo info);
}

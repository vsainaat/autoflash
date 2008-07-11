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
    double rentBattery(int stationID, int vehicleID, int batteryID, double amount);

    double returnBattery(int stationID, int vechildID, int batteryID, double amount);

    BatteryInfo moveBatteryToStation(int stationID, int batteryID);

    BatteryInfo moveBatteryFromStation(int stationID, int batteryID);

    void reportDamagedBattery(int stationID, int batteryID);

    int registerVehicle(int stationID, VehicleInfo info);

    void openStation(int stationID);

    void closeStation(int stationID);

    BatteryInfo moveBatteryToDepot(int depotID, int batteryID);

    BatteryInfo moveBatteryFromDepot(int depotID, int batteryID);

    void charge(int depotID, int batteryID, double currentAmount, double useAmount);

    void discard(int depotID, int BatteryID);

    void openDepot(int depotID);

    void closeDepot(int depotID);

    void purchase(BatteryInfo info);

    Activity[] queryActivities(int start, int end);

    Activity[] queryBatteryActivities(int batteryID, int start, int end);

    Activity[] queryStationActivities(int staionID, int start, int end);

    Activity[] queryDepotActivities(int staionID, int start, int end);

    StationInfo[] queryStations(StationQueryCondition c);

    DepotInfo[] queryDepots(DepotQueryCondition c);

    BatteryInfo[] queryBatteries(BatteryQueryCondition c);

    VehicleInfo[] queryVehicles(VehicleQueryCondition c);

    int registerStation(StationInfo info);

    void unregisterStation(int stationID);

    void setStation(int stationID, StationInfo info);

    int registerDepot(DepotInfo info);

    void unregisterDepot(int depotID);

    void setDepot(int depotID, DepotInfo info);
}

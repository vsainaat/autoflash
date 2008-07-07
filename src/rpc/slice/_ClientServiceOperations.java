// **********************************************************************
//
// Copyright (c) 2003-2007 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.2.1

package rpc.slice;

public interface _ClientServiceOperations
{
    double rentBattery(int stationID, int vehicleID, int batteryID, double amount, Ice.Current __current);

    double returnBattery(int stationID, int vechildID, int batteryID, double amount, Ice.Current __current);

    BatteryInfo moveBatteryToStation(int stationID, int batteryID, Ice.Current __current);

    BatteryInfo moveBatteryFromStation(int stationID, int batteryID, Ice.Current __current);

    void reportDamagedBattery(int stationID, int batteryID, Ice.Current __current);

    int registerVehicle(int stationID, VehicleInfo info, Ice.Current __current);

    void openStation(int stationID, Ice.Current __current);

    void closeStation(int stationID, Ice.Current __current);

    BatteryInfo moveBatteryToDepot(int depotID, int batteryID, Ice.Current __current);

    BatteryInfo moveBatteryFromDepot(int depotID, int batteryID, Ice.Current __current);

    void charge(int stationID, int batteryID, double currentAmount, double useAmount, Ice.Current __current);

    void discard(int BatteryID, Ice.Current __current);

    void openDepot(int depotID, Ice.Current __current);

    void closeDepot(int depotID, Ice.Current __current);

    void purchase(BatteryInfo info, Ice.Current __current);

    Activity[] queryActivities(int start, int end, Ice.Current __current);

    Activity[] queryBatteryActivities(int batteryID, int start, int end, Ice.Current __current);

    Activity[] queryStationActivities(int staionID, int start, int end, Ice.Current __current);

    Activity[] queryDepotActivities(int staionID, int start, int end, Ice.Current __current);

    StationInfo[] queryStations(StationQueryCondition c, Ice.Current __current);

    DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current __current);

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current __current);

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current __current);

    int registerStation(StationInfo info, Ice.Current __current);

    int registerDepot(DepotInfo info, Ice.Current __current);

    void unregisterStation(int stationID, Ice.Current __current);

    void setStation(int stationID, StationInfo info, Ice.Current __current);

    void unregisterDepot(DepotInfo info, Ice.Current __current);

    void setDepot(int stationID, DepotInfo info, Ice.Current __current);
}

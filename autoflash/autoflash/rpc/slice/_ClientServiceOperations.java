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
    double rentBattery(String stationID, String vehicleID, String batteryID, double amount, Ice.Current __current)
        throws OperationError;

    double returnBattery(String stationID, String vechildID, String batteryID, double amount, Ice.Current __current)
        throws OperationError;

    void moveBatteryToStation(String stationID, String batteryID, Ice.Current __current)
        throws OperationError;

    void moveBatteryFromStation(String stationID, String batteryID, Ice.Current __current)
        throws OperationError;

    void reportDamagedBattery(String stationID, String batteryID, Ice.Current __current)
        throws OperationError;

    String registerVehicle(String stationID, VehicleInfo info, Ice.Current __current)
        throws OperationError;

    void openStation(String stationID, Ice.Current __current)
        throws OperationError;

    void closeStation(String stationID, Ice.Current __current)
        throws OperationError;

    void moveBatteryToDepot(String depotID, String batteryID, Ice.Current __current)
        throws OperationError;

    void moveBatteryFromDepot(String depotID, String batteryID, Ice.Current __current)
        throws OperationError;

    void charge(String depotID, String batteryID, double currentAmount, double useAmount, Ice.Current __current)
        throws OperationError;

    void discard(String depotID, String batteryID, Ice.Current __current)
        throws OperationError;

    void openDepot(String depotID, Ice.Current __current)
        throws OperationError;

    void closeDepot(String depotID, Ice.Current __current)
        throws OperationError;

    String purchase(BatteryInfo info, double price, Ice.Current __current)
        throws OperationError;

    Activity[] queryActivities(long start, long end, Ice.Current __current);

    Activity[] queryBatteryActivities(String batteryID, long start, long end, Ice.Current __current)
        throws OperationError;

    Activity[] queryStationActivities(String staionID, long start, long end, Ice.Current __current)
        throws OperationError;

    Activity[] queryDepotActivities(String staionID, long start, long end, Ice.Current __current)
        throws OperationError;

    StationInfo[] queryStations(StationQueryCondition c, Ice.Current __current)
        throws OperationError;

    DepotInfo[] queryDepots(DepotQueryCondition c, Ice.Current __current)
        throws OperationError;

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, Ice.Current __current)
        throws OperationError;

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, Ice.Current __current)
        throws OperationError;

    String registerStation(StationInfo info, Ice.Current __current)
        throws OperationError;

    String registerDepot(DepotInfo info, Ice.Current __current)
        throws OperationError;

    void unregisterStation(String stationID, Ice.Current __current)
        throws OperationError;

    void setStation(String stationID, StationInfo info, Ice.Current __current)
        throws OperationError;

    void unregisterDepot(String depotID, Ice.Current __current)
        throws OperationError;

    void setDepot(String stationID, DepotInfo info, Ice.Current __current)
        throws OperationError;

    void setUnitPrice(double price, Ice.Current __current)
        throws OperationError;

    void setUnitChargePrice(double price, Ice.Current __current)
        throws OperationError;
}

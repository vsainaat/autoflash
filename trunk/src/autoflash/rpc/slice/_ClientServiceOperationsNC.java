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
    double rentBattery(String stationID, String vehicleID, String batteryID, double amount)
        throws OperationError;

    double returnBattery(String stationID, String vechildID, String batteryID, double amount)
        throws OperationError;

    void moveBatteryToStation(String stationID, String batteryID)
        throws OperationError;

    void moveBatteryFromStation(String stationID, String batteryID)
        throws OperationError;

    void reportDamagedBattery(String stationID, String batteryID)
        throws OperationError;

    String registerVehicle(String stationID, VehicleInfo info)
        throws OperationError;

    void openStation(String stationID)
        throws OperationError;

    void closeStation(String stationID)
        throws OperationError;

    void moveBatteryToDepot(String depotID, String batteryID)
        throws OperationError;

    void moveBatteryFromDepot(String depotID, String batteryID)
        throws OperationError;

    void charge(String depotID, String batteryID, double currentAmount, double useAmount)
        throws OperationError;

    void discard(String depotID, String batteryID)
        throws OperationError;

    void openDepot(String depotID)
        throws OperationError;

    void closeDepot(String depotID)
        throws OperationError;

    String purchase(BatteryInfo info, double price)
        throws OperationError;

    Activity[] queryActivities(long start, long end);

    Activity[] queryBatteryActivities(String batteryID, long start, long end)
        throws OperationError;

    Activity[] queryStationActivities(String staionID, long start, long end)
        throws OperationError;

    Activity[] queryDepotActivities(String staionID, long start, long end)
        throws OperationError;

    StationInfo[] queryStations(StationQueryCondition c)
        throws OperationError;

    DepotInfo[] queryDepots(DepotQueryCondition c)
        throws OperationError;

    BatteryInfo[] queryBatteries(BatteryQueryCondition c)
        throws OperationError;

    VehicleInfo[] queryVehicles(VehicleQueryCondition c)
        throws OperationError;

    String registerStation(StationInfo info)
        throws OperationError;

    String registerDepot(DepotInfo info)
        throws OperationError;

    void unregisterStation(String stationID)
        throws OperationError;

    void setStation(String stationID, StationInfo info)
        throws OperationError;

    void unregisterDepot(String depotID)
        throws OperationError;

    void setDepot(String stationID, DepotInfo info)
        throws OperationError;

    void setUnitPrice(double price)
        throws OperationError;

    void setUnitChargePrice(double price)
        throws OperationError;
}

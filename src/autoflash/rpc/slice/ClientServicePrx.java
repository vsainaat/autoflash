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

public interface ClientServicePrx extends Ice.ObjectPrx
{
    public double rentBattery(String stationID, String vehicleID, String batteryID, double amount)
        throws OperationError;
    public double rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws OperationError;

    public double returnBattery(String stationID, String vechildID, String batteryID, double amount)
        throws OperationError;
    public double returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void moveBatteryToStation(String stationID, String batteryID)
        throws OperationError;
    public void moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void moveBatteryFromStation(String stationID, String batteryID)
        throws OperationError;
    public void moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void reportDamagedBattery(String stationID, String batteryID)
        throws OperationError;
    public void reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public String registerVehicle(String stationID, VehicleInfo info)
        throws OperationError;
    public String registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void openStation(String stationID)
        throws OperationError;
    public void openStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void closeStation(String stationID)
        throws OperationError;
    public void closeStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void moveBatteryToDepot(String depotID, String batteryID)
        throws OperationError;
    public void moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void moveBatteryFromDepot(String depotID, String batteryID)
        throws OperationError;
    public void moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void charge(String depotID, String batteryID, double currentAmount, double useAmount)
        throws OperationError;
    public void charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void discard(String depotID, String batteryID)
        throws OperationError;
    public void discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void openDepot(String depotID)
        throws OperationError;
    public void openDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void closeDepot(String depotID)
        throws OperationError;
    public void closeDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public String purchase(BatteryInfo info, double price)
        throws OperationError;
    public String purchase(BatteryInfo info, double price, java.util.Map<String, String> __ctx)
        throws OperationError;

    public Activity[] queryActivities(long start, long end);
    public Activity[] queryActivities(long start, long end, java.util.Map<String, String> __ctx);

    public Activity[] queryBatteryActivities(String batteryID, long start, long end)
        throws OperationError;
    public Activity[] queryBatteryActivities(String batteryID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError;

    public Activity[] queryStationActivities(String staionID, long start, long end)
        throws OperationError;
    public Activity[] queryStationActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError;

    public Activity[] queryDepotActivities(String staionID, long start, long end)
        throws OperationError;
    public Activity[] queryDepotActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError;

    public StationInfo[] queryStations(StationQueryCondition c)
        throws OperationError;
    public StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError;

    public DepotInfo[] queryDepots(DepotQueryCondition c)
        throws OperationError;
    public DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError;

    public BatteryInfo[] queryBatteries(BatteryQueryCondition c)
        throws OperationError;
    public BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError;

    public VehicleInfo[] queryVehicles(VehicleQueryCondition c)
        throws OperationError;
    public VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError;

    public String registerStation(StationInfo info)
        throws OperationError;
    public String registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws OperationError;

    public String registerDepot(DepotInfo info)
        throws OperationError;
    public String registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void unregisterStation(String stationID)
        throws OperationError;
    public void unregisterStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void setStation(String stationID, StationInfo info)
        throws OperationError;
    public void setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void unregisterDepot(String depotID)
        throws OperationError;
    public void unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void setDepot(String stationID, DepotInfo info)
        throws OperationError;
    public void setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void setUnitPrice(double price)
        throws OperationError;
    public void setUnitPrice(double price, java.util.Map<String, String> __ctx)
        throws OperationError;

    public void setUnitChargePrice(double price)
        throws OperationError;
    public void setUnitChargePrice(double price, java.util.Map<String, String> __ctx)
        throws OperationError;
}

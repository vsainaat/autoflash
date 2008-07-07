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

public interface ClientServicePrx extends Ice.ObjectPrx
{
    public double rentBattery(int stationID, int vehicleID, int batteryID, double amount);
    public double rentBattery(int stationID, int vehicleID, int batteryID, double amount, java.util.Map<String, String> __ctx);

    public double returnBattery(int stationID, int vechildID, int batteryID, double amount);
    public double returnBattery(int stationID, int vechildID, int batteryID, double amount, java.util.Map<String, String> __ctx);

    public BatteryInfo moveBatteryToStation(int stationID, int batteryID);
    public BatteryInfo moveBatteryToStation(int stationID, int batteryID, java.util.Map<String, String> __ctx);

    public BatteryInfo moveBatteryFromStation(int stationID, int batteryID);
    public BatteryInfo moveBatteryFromStation(int stationID, int batteryID, java.util.Map<String, String> __ctx);

    public void reportDamagedBattery(int stationID, int batteryID);
    public void reportDamagedBattery(int stationID, int batteryID, java.util.Map<String, String> __ctx);

    public int registerVehicle(int stationID, VehicleInfo info);
    public int registerVehicle(int stationID, VehicleInfo info, java.util.Map<String, String> __ctx);

    public void openStation(int stationID);
    public void openStation(int stationID, java.util.Map<String, String> __ctx);

    public void closeStation(int stationID);
    public void closeStation(int stationID, java.util.Map<String, String> __ctx);

    public BatteryInfo moveBatteryToDepot(int depotID, int batteryID);
    public BatteryInfo moveBatteryToDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx);

    public BatteryInfo moveBatteryFromDepot(int depotID, int batteryID);
    public BatteryInfo moveBatteryFromDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx);

    public void charge(int stationID, int batteryID, double currentAmount, double useAmount);
    public void charge(int stationID, int batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx);

    public void discard(int BatteryID);
    public void discard(int BatteryID, java.util.Map<String, String> __ctx);

    public void openDepot(int depotID);
    public void openDepot(int depotID, java.util.Map<String, String> __ctx);

    public void closeDepot(int depotID);
    public void closeDepot(int depotID, java.util.Map<String, String> __ctx);

    public void purchase(BatteryInfo info);
    public void purchase(BatteryInfo info, java.util.Map<String, String> __ctx);

    public Activity[] queryActivities(int start, int end);
    public Activity[] queryActivities(int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryBatteryActivities(int batteryID, int start, int end);
    public Activity[] queryBatteryActivities(int batteryID, int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryStationActivities(int staionID, int start, int end);
    public Activity[] queryStationActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryDepotActivities(int staionID, int start, int end);
    public Activity[] queryDepotActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx);

    public StationInfo[] queryStations(StationQueryCondition c);
    public StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx);

    public DepotInfo[] queryDepots(DepotQueryCondition c);
    public DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx);

    public BatteryInfo[] queryBatteries(BatteryQueryCondition c);
    public BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx);

    public VehicleInfo[] queryVehicles(VehicleQueryCondition c);
    public VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx);

    public int registerStation(StationInfo info);
    public int registerStation(StationInfo info, java.util.Map<String, String> __ctx);

    public int registerDepot(DepotInfo info);
    public int registerDepot(DepotInfo info, java.util.Map<String, String> __ctx);

    public void unregisterStation(int stationID);
    public void unregisterStation(int stationID, java.util.Map<String, String> __ctx);

    public void setStation(int stationID, StationInfo info);
    public void setStation(int stationID, StationInfo info, java.util.Map<String, String> __ctx);

    public void unregisterDepot(DepotInfo info);
    public void unregisterDepot(DepotInfo info, java.util.Map<String, String> __ctx);

    public void setDepot(int stationID, DepotInfo info);
    public void setDepot(int stationID, DepotInfo info, java.util.Map<String, String> __ctx);
}

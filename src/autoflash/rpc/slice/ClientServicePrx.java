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
    public double rentBattery(String stationID, String vehicleID, String batteryID, double amount);
    public double rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx);

    public double returnBattery(String stationID, String vechildID, String batteryID, double amount);
    public double returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx);

    public void moveBatteryToStation(String stationID, String batteryID);
    public void moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx);

    public void moveBatteryFromStation(String stationID, String batteryID);
    public void moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx);

    public void reportDamagedBattery(String stationID, String batteryID);
    public void reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx);

    public String registerVehicle(String stationID, VehicleInfo info);
    public String registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx);

    public void openStation(String stationID);
    public void openStation(String stationID, java.util.Map<String, String> __ctx);

    public void closeStation(String stationID);
    public void closeStation(String stationID, java.util.Map<String, String> __ctx);

    public void moveBatteryToDepot(String depotID, String batteryID);
    public void moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx);

    public void moveBatteryFromDepot(String depotID, String batteryID);
    public void moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx);

    public void charge(String depotID, String batteryID, double currentAmount, double useAmount);
    public void charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx);

    public void discard(String depotID, String batteryID);
    public void discard(String depotID, String batteryID, java.util.Map<String, String> __ctx);

    public void openDepot(String depotID);
    public void openDepot(String depotID, java.util.Map<String, String> __ctx);

    public void closeDepot(String depotID);
    public void closeDepot(String depotID, java.util.Map<String, String> __ctx);

    public String purchase(BatteryInfo info);
    public String purchase(BatteryInfo info, java.util.Map<String, String> __ctx);

    public Activity[] queryActivities(int start, int end);
    public Activity[] queryActivities(int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryBatteryActivities(String batteryID, int start, int end);
    public Activity[] queryBatteryActivities(String batteryID, int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryStationActivities(String staionID, int start, int end);
    public Activity[] queryStationActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx);

    public Activity[] queryDepotActivities(String staionID, int start, int end);
    public Activity[] queryDepotActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx);

    public StationInfo[] queryStations(StationQueryCondition c);
    public StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx);

    public DepotInfo[] queryDepots(DepotQueryCondition c);
    public DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx);

    public BatteryInfo[] queryBatteries(BatteryQueryCondition c);
    public BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx);

    public VehicleInfo[] queryVehicles(VehicleQueryCondition c);
    public VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx);

    public String registerStation(StationInfo info);
    public String registerStation(StationInfo info, java.util.Map<String, String> __ctx);

    public String registerDepot(DepotInfo info);
    public String registerDepot(DepotInfo info, java.util.Map<String, String> __ctx);

    public void unregisterStation(String stationID);
    public void unregisterStation(String stationID, java.util.Map<String, String> __ctx);

    public void setStation(String stationID, StationInfo info);
    public void setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx);

    public void unregisterDepot(String depotID);
    public void unregisterDepot(String depotID, java.util.Map<String, String> __ctx);

    public void setDepot(String stationID, DepotInfo info);
    public void setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx);
}

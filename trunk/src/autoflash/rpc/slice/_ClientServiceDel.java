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

public interface _ClientServiceDel extends Ice._ObjectDel
{
    double rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    double returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void openStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void closeStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void charge(String stationID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void openDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void closeDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void purchase(BatteryInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryActivities(int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryBatteryActivities(String batteryID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryStationActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryDepotActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void unregisterStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}

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
    double rentBattery(int stationID, int vehicleID, int batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    double returnBattery(int stationID, int vechildID, int batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryToStation(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryFromStation(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void reportDamagedBattery(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int registerVehicle(int stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void openStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void closeStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryToDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo moveBatteryFromDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void charge(int depotID, int batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void discard(int depotID, int BatteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void openDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void closeDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void purchase(BatteryInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryActivities(int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryBatteryActivities(int batteryID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryStationActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryDepotActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void unregisterStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void setStation(int stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void unregisterDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void setDepot(int depotID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}

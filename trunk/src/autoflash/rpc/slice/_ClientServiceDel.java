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
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    double returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    String registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void openStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void closeStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void openDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void closeDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    String purchase(BatteryInfo info, double price, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    Activity[] queryActivities(long start, long end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Activity[] queryBatteryActivities(String batteryID, long start, long end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    Activity[] queryStationActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    Activity[] queryDepotActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    StationInfo[] queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    DepotInfo[] queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    BatteryInfo[] queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    VehicleInfo[] queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    String registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    String registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void unregisterStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void setUnitPrice(double price, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;

    void setUnitChargePrice(double price, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper,
               OperationError;
}

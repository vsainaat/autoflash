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

public abstract class _ClientServiceDisp extends Ice.ObjectImpl implements ClientService
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::autoflash::rpc::slice::ClientService"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public final void
    charge(String depotID, String batteryID, double currentAmount, double useAmount)
        throws OperationError
    {
        charge(depotID, batteryID, currentAmount, useAmount, null);
    }

    public final void
    closeDepot(String depotID)
        throws OperationError
    {
        closeDepot(depotID, null);
    }

    public final void
    closeStation(String stationID)
        throws OperationError
    {
        closeStation(stationID, null);
    }

    public final void
    discard(String depotID, String batteryID)
        throws OperationError
    {
        discard(depotID, batteryID, null);
    }

    public final void
    moveBatteryFromDepot(String depotID, String batteryID)
        throws OperationError
    {
        moveBatteryFromDepot(depotID, batteryID, null);
    }

    public final void
    moveBatteryFromStation(String stationID, String batteryID)
        throws OperationError
    {
        moveBatteryFromStation(stationID, batteryID, null);
    }

    public final void
    moveBatteryToDepot(String depotID, String batteryID)
        throws OperationError
    {
        moveBatteryToDepot(depotID, batteryID, null);
    }

    public final void
    moveBatteryToStation(String stationID, String batteryID)
        throws OperationError
    {
        moveBatteryToStation(stationID, batteryID, null);
    }

    public final void
    openDepot(String depotID)
        throws OperationError
    {
        openDepot(depotID, null);
    }

    public final void
    openStation(String stationID)
        throws OperationError
    {
        openStation(stationID, null);
    }

    public final String
    purchase(BatteryInfo info, double price)
        throws OperationError
    {
        return purchase(info, price, null);
    }

    public final Activity[]
    queryActivities(long start, long end)
    {
        return queryActivities(start, end, null);
    }

    public final BatteryInfo[]
    queryBatteries(BatteryQueryCondition c)
        throws OperationError
    {
        return queryBatteries(c, null);
    }

    public final Activity[]
    queryBatteryActivities(String batteryID, long start, long end)
        throws OperationError
    {
        return queryBatteryActivities(batteryID, start, end, null);
    }

    public final Activity[]
    queryDepotActivities(String staionID, long start, long end)
        throws OperationError
    {
        return queryDepotActivities(staionID, start, end, null);
    }

    public final DepotInfo[]
    queryDepots(DepotQueryCondition c)
        throws OperationError
    {
        return queryDepots(c, null);
    }

    public final Activity[]
    queryStationActivities(String staionID, long start, long end)
        throws OperationError
    {
        return queryStationActivities(staionID, start, end, null);
    }

    public final StationInfo[]
    queryStations(StationQueryCondition c)
        throws OperationError
    {
        return queryStations(c, null);
    }

    public final VehicleInfo[]
    queryVehicles(VehicleQueryCondition c)
        throws OperationError
    {
        return queryVehicles(c, null);
    }

    public final String
    registerDepot(DepotInfo info)
        throws OperationError
    {
        return registerDepot(info, null);
    }

    public final String
    registerStation(StationInfo info)
        throws OperationError
    {
        return registerStation(info, null);
    }

    public final String
    registerVehicle(String stationID, VehicleInfo info)
        throws OperationError
    {
        return registerVehicle(stationID, info, null);
    }

    public final double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount)
        throws OperationError
    {
        return rentBattery(stationID, vehicleID, batteryID, amount, null);
    }

    public final void
    reportDamagedBattery(String stationID, String batteryID)
        throws OperationError
    {
        reportDamagedBattery(stationID, batteryID, null);
    }

    public final double
    returnBattery(String stationID, String vechildID, String batteryID, double amount)
        throws OperationError
    {
        return returnBattery(stationID, vechildID, batteryID, amount, null);
    }

    public final void
    setDepot(String stationID, DepotInfo info)
        throws OperationError
    {
        setDepot(stationID, info, null);
    }

    public final void
    setStation(String stationID, StationInfo info)
        throws OperationError
    {
        setStation(stationID, info, null);
    }

    public final void
    setUnitChargePrice(double price)
        throws OperationError
    {
        setUnitChargePrice(price, null);
    }

    public final void
    setUnitPrice(double price)
        throws OperationError
    {
        setUnitPrice(price, null);
    }

    public final void
    unregisterDepot(String depotID)
        throws OperationError
    {
        unregisterDepot(depotID, null);
    }

    public final void
    unregisterStation(String stationID)
        throws OperationError
    {
        unregisterStation(stationID, null);
    }

    public static IceInternal.DispatchStatus
    ___rentBattery(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        String vehicleID;
        vehicleID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        double amount;
        amount = __is.readDouble();
        try
        {
            double __ret = __obj.rentBattery(stationID, vehicleID, batteryID, amount, __current);
            __os.writeDouble(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___returnBattery(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        String vechildID;
        vechildID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        double amount;
        amount = __is.readDouble();
        try
        {
            double __ret = __obj.returnBattery(stationID, vechildID, batteryID, amount, __current);
            __os.writeDouble(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___moveBatteryToStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.moveBatteryToStation(stationID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___moveBatteryFromStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.moveBatteryFromStation(stationID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___reportDamagedBattery(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.reportDamagedBattery(stationID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___registerVehicle(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        VehicleInfo info;
        info = new VehicleInfo();
        info.__read(__is);
        try
        {
            String __ret = __obj.registerVehicle(stationID, info, __current);
            __os.writeString(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___openStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        try
        {
            __obj.openStation(stationID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___closeStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        try
        {
            __obj.closeStation(stationID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___moveBatteryToDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.moveBatteryToDepot(depotID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___moveBatteryFromDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.moveBatteryFromDepot(depotID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___charge(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        double currentAmount;
        currentAmount = __is.readDouble();
        double useAmount;
        useAmount = __is.readDouble();
        try
        {
            __obj.charge(depotID, batteryID, currentAmount, useAmount, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___discard(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        String batteryID;
        batteryID = __is.readString();
        try
        {
            __obj.discard(depotID, batteryID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___openDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        try
        {
            __obj.openDepot(depotID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___closeDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        try
        {
            __obj.closeDepot(depotID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___purchase(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        BatteryInfo info;
        info = new BatteryInfo();
        info.__read(__is);
        double price;
        price = __is.readDouble();
        try
        {
            String __ret = __obj.purchase(info, price, __current);
            __os.writeString(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryActivities(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        long start;
        start = __is.readLong();
        long end;
        end = __is.readLong();
        Activity[] __ret = __obj.queryActivities(start, end, __current);
        ActivitiesHelper.write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___queryBatteryActivities(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String batteryID;
        batteryID = __is.readString();
        long start;
        start = __is.readLong();
        long end;
        end = __is.readLong();
        try
        {
            Activity[] __ret = __obj.queryBatteryActivities(batteryID, start, end, __current);
            ActivitiesHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryStationActivities(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String staionID;
        staionID = __is.readString();
        long start;
        start = __is.readLong();
        long end;
        end = __is.readLong();
        try
        {
            Activity[] __ret = __obj.queryStationActivities(staionID, start, end, __current);
            ActivitiesHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryDepotActivities(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String staionID;
        staionID = __is.readString();
        long start;
        start = __is.readLong();
        long end;
        end = __is.readLong();
        try
        {
            Activity[] __ret = __obj.queryDepotActivities(staionID, start, end, __current);
            ActivitiesHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryStations(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        StationQueryCondition c;
        c = new StationQueryCondition();
        c.__read(__is);
        try
        {
            StationInfo[] __ret = __obj.queryStations(c, __current);
            StationsInfoHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryDepots(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        DepotQueryCondition c;
        c = new DepotQueryCondition();
        c.__read(__is);
        try
        {
            DepotInfo[] __ret = __obj.queryDepots(c, __current);
            DepotsInfoHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryBatteries(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        BatteryQueryCondition c;
        c = new BatteryQueryCondition();
        c.__read(__is);
        try
        {
            BatteryInfo[] __ret = __obj.queryBatteries(c, __current);
            BatteriesInfoHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___queryVehicles(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        VehicleQueryCondition c;
        c = new VehicleQueryCondition();
        c.__read(__is);
        try
        {
            VehicleInfo[] __ret = __obj.queryVehicles(c, __current);
            VehiclesInfoHelper.write(__os, __ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___registerStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        StationInfo info;
        info = new StationInfo();
        info.__read(__is);
        try
        {
            String __ret = __obj.registerStation(info, __current);
            __os.writeString(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___registerDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        DepotInfo info;
        info = new DepotInfo();
        info.__read(__is);
        try
        {
            String __ret = __obj.registerDepot(info, __current);
            __os.writeString(__ret);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___unregisterStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        try
        {
            __obj.unregisterStation(stationID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___setStation(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        StationInfo info;
        info = new StationInfo();
        info.__read(__is);
        try
        {
            __obj.setStation(stationID, info, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___unregisterDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String depotID;
        depotID = __is.readString();
        try
        {
            __obj.unregisterDepot(depotID, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___setDepot(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String stationID;
        stationID = __is.readString();
        DepotInfo info;
        info = new DepotInfo();
        info.__read(__is);
        try
        {
            __obj.setDepot(stationID, info, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___setUnitPrice(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        double price;
        price = __is.readDouble();
        try
        {
            __obj.setUnitPrice(price, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    public static IceInternal.DispatchStatus
    ___setUnitChargePrice(ClientService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        double price;
        price = __is.readDouble();
        try
        {
            __obj.setUnitChargePrice(price, __current);
            return IceInternal.DispatchStatus.DispatchOK;
        }
        catch(OperationError ex)
        {
            __os.writeUserException(ex);
            return IceInternal.DispatchStatus.DispatchUserException;
        }
    }

    private final static String[] __all =
    {
        "charge",
        "closeDepot",
        "closeStation",
        "discard",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "moveBatteryFromDepot",
        "moveBatteryFromStation",
        "moveBatteryToDepot",
        "moveBatteryToStation",
        "openDepot",
        "openStation",
        "purchase",
        "queryActivities",
        "queryBatteries",
        "queryBatteryActivities",
        "queryDepotActivities",
        "queryDepots",
        "queryStationActivities",
        "queryStations",
        "queryVehicles",
        "registerDepot",
        "registerStation",
        "registerVehicle",
        "rentBattery",
        "reportDamagedBattery",
        "returnBattery",
        "setDepot",
        "setStation",
        "setUnitChargePrice",
        "setUnitPrice",
        "unregisterDepot",
        "unregisterStation"
    };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            return IceInternal.DispatchStatus.DispatchOperationNotExist;
        }

        switch(pos)
        {
            case 0:
            {
                return ___charge(this, in, __current);
            }
            case 1:
            {
                return ___closeDepot(this, in, __current);
            }
            case 2:
            {
                return ___closeStation(this, in, __current);
            }
            case 3:
            {
                return ___discard(this, in, __current);
            }
            case 4:
            {
                return ___ice_id(this, in, __current);
            }
            case 5:
            {
                return ___ice_ids(this, in, __current);
            }
            case 6:
            {
                return ___ice_isA(this, in, __current);
            }
            case 7:
            {
                return ___ice_ping(this, in, __current);
            }
            case 8:
            {
                return ___moveBatteryFromDepot(this, in, __current);
            }
            case 9:
            {
                return ___moveBatteryFromStation(this, in, __current);
            }
            case 10:
            {
                return ___moveBatteryToDepot(this, in, __current);
            }
            case 11:
            {
                return ___moveBatteryToStation(this, in, __current);
            }
            case 12:
            {
                return ___openDepot(this, in, __current);
            }
            case 13:
            {
                return ___openStation(this, in, __current);
            }
            case 14:
            {
                return ___purchase(this, in, __current);
            }
            case 15:
            {
                return ___queryActivities(this, in, __current);
            }
            case 16:
            {
                return ___queryBatteries(this, in, __current);
            }
            case 17:
            {
                return ___queryBatteryActivities(this, in, __current);
            }
            case 18:
            {
                return ___queryDepotActivities(this, in, __current);
            }
            case 19:
            {
                return ___queryDepots(this, in, __current);
            }
            case 20:
            {
                return ___queryStationActivities(this, in, __current);
            }
            case 21:
            {
                return ___queryStations(this, in, __current);
            }
            case 22:
            {
                return ___queryVehicles(this, in, __current);
            }
            case 23:
            {
                return ___registerDepot(this, in, __current);
            }
            case 24:
            {
                return ___registerStation(this, in, __current);
            }
            case 25:
            {
                return ___registerVehicle(this, in, __current);
            }
            case 26:
            {
                return ___rentBattery(this, in, __current);
            }
            case 27:
            {
                return ___reportDamagedBattery(this, in, __current);
            }
            case 28:
            {
                return ___returnBattery(this, in, __current);
            }
            case 29:
            {
                return ___setDepot(this, in, __current);
            }
            case 30:
            {
                return ___setStation(this, in, __current);
            }
            case 31:
            {
                return ___setUnitChargePrice(this, in, __current);
            }
            case 32:
            {
                return ___setUnitPrice(this, in, __current);
            }
            case 33:
            {
                return ___unregisterDepot(this, in, __current);
            }
            case 34:
            {
                return ___unregisterStation(this, in, __current);
            }
        }

        assert(false);
        return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type autoflash::rpc::slice::ClientService was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type autoflash::rpc::slice::ClientService was not generated with stream support";
        throw ex;
    }
}

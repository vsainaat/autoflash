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

public final class _ClientServiceDelM extends Ice._ObjectDelM implements _ClientServiceDel
{
    public void
    charge(String stationID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "charge", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(batteryID);
                __os.writeDouble(currentAmount);
                __os.writeDouble(useAmount);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    closeDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "closeDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    closeStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "closeStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "discard", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public BatteryInfo
    moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "moveBatteryFromDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                BatteryInfo __ret;
                __ret = new BatteryInfo();
                __ret.__read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public BatteryInfo
    moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "moveBatteryFromStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                BatteryInfo __ret;
                __ret = new BatteryInfo();
                __ret.__read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public BatteryInfo
    moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "moveBatteryToDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                BatteryInfo __ret;
                __ret = new BatteryInfo();
                __ret.__read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public BatteryInfo
    moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "moveBatteryToStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                BatteryInfo __ret;
                __ret = new BatteryInfo();
                __ret.__read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    openDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "openDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    openStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "openStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    purchase(BatteryInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "purchase", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public Activity[]
    queryActivities(int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryActivities", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeInt(start);
                __os.writeInt(end);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                Activity[] __ret;
                __ret = ActivitiesHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryBatteries", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                c.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                BatteryInfo[] __ret;
                __ret = BatteriesInfoHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public Activity[]
    queryBatteryActivities(String batteryID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryBatteryActivities", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(batteryID);
                __os.writeInt(start);
                __os.writeInt(end);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                Activity[] __ret;
                __ret = ActivitiesHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public Activity[]
    queryDepotActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryDepotActivities", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(staionID);
                __os.writeInt(start);
                __os.writeInt(end);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                Activity[] __ret;
                __ret = ActivitiesHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryDepots", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                c.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                DepotInfo[] __ret;
                __ret = DepotsInfoHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public Activity[]
    queryStationActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryStationActivities", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(staionID);
                __os.writeInt(start);
                __os.writeInt(end);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                Activity[] __ret;
                __ret = ActivitiesHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryStations", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                c.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                StationInfo[] __ret;
                __ret = StationsInfoHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "queryVehicles", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                c.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                VehicleInfo[] __ret;
                __ret = VehiclesInfoHelper.read(__is);
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public String
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "registerDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                String __ret;
                __ret = __is.readString();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public String
    registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "registerStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                String __ret;
                __ret = __is.readString();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public String
    registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "registerVehicle", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                String __ret;
                __ret = __is.readString();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "rentBattery", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(vehicleID);
                __os.writeString(batteryID);
                __os.writeDouble(amount);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                double __ret;
                __ret = __is.readDouble();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "reportDamagedBattery", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(batteryID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public double
    returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "returnBattery", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                __os.writeString(vechildID);
                __os.writeString(batteryID);
                __os.writeDouble(amount);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                double __ret;
                __ret = __is.readDouble();
                return __ret;
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "setDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "setStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
                info.__write(__os);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unregisterDepot", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(depotID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }

    public void
    unregisterStation(String stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unregisterStation", Ice.OperationMode.Normal, __ctx, __compress);
        try
        {
            try
            {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(stationID);
            }
            catch(Ice.LocalException __ex)
            {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try
            {
                IceInternal.BasicStream __is = __og.is();
                if(!__ok)
                {
                    try
                    {
                        __is.throwException();
                    }
                    catch(Ice.UserException __ex)
                    {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
            }
            catch(Ice.LocalException __ex)
            {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        }
        finally
        {
            __connection.reclaimOutgoing(__og);
        }
    }
}

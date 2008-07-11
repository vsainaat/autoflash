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

public final class _ClientServiceDelD extends Ice._ObjectDelD implements _ClientServiceDel
{
    public void
    charge(int depotID, int batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "charge", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.charge(depotID, batteryID, currentAmount, useAmount, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    closeDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "closeDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.closeDepot(depotID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    closeStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "closeStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.closeStation(stationID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    discard(int depotID, int BatteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "discard", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.discard(depotID, BatteryID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public BatteryInfo
    moveBatteryFromDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "moveBatteryFromDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.moveBatteryFromDepot(depotID, batteryID, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public BatteryInfo
    moveBatteryFromStation(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "moveBatteryFromStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.moveBatteryFromStation(stationID, batteryID, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public BatteryInfo
    moveBatteryToDepot(int depotID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "moveBatteryToDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.moveBatteryToDepot(depotID, batteryID, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public BatteryInfo
    moveBatteryToStation(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "moveBatteryToStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.moveBatteryToStation(stationID, batteryID, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    openDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "openDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.openDepot(depotID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    openStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "openStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.openStation(stationID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    purchase(BatteryInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "purchase", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.purchase(info, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public Activity[]
    queryActivities(int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryActivities", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryActivities(start, end, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryBatteries", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryBatteries(c, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public Activity[]
    queryBatteryActivities(int batteryID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryBatteryActivities", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryBatteryActivities(batteryID, start, end, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public Activity[]
    queryDepotActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryDepotActivities", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryDepotActivities(staionID, start, end, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryDepots", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryDepots(c, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public Activity[]
    queryStationActivities(int staionID, int start, int end, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryStationActivities", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryStationActivities(staionID, start, end, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryStations", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryStations(c, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "queryVehicles", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.queryVehicles(c, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public int
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "registerDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.registerDepot(info, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public int
    registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "registerStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.registerStation(info, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public int
    registerVehicle(int stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "registerVehicle", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.registerVehicle(stationID, info, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public double
    rentBattery(int stationID, int vehicleID, int batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "rentBattery", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.rentBattery(stationID, vehicleID, batteryID, amount, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    reportDamagedBattery(int stationID, int batteryID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "reportDamagedBattery", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.reportDamagedBattery(stationID, batteryID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public double
    returnBattery(int stationID, int vechildID, int batteryID, double amount, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "returnBattery", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    return __servant.returnBattery(stationID, vechildID, batteryID, amount, __current);
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    setDepot(int depotID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "setDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.setDepot(depotID, info, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    setStation(int stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "setStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.setStation(stationID, info, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    unregisterDepot(int depotID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "unregisterDepot", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.unregisterDepot(depotID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }

    public void
    unregisterStation(int stationID, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper
    {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "unregisterStation", Ice.OperationMode.Normal, __ctx);
        while(true)
        {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try
            {
                ClientService __servant = null;
                try
                {
                    __servant = (ClientService)__direct.servant();
                }
                catch(ClassCastException __ex)
                {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try
                {
                    __servant.unregisterStation(stationID, __current);
                    return;
                }
                catch(Ice.LocalException __ex)
                {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            }
            finally
            {
                __direct.destroy();
            }
        }
    }
}

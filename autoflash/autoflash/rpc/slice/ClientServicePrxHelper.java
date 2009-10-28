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

public final class ClientServicePrxHelper extends Ice.ObjectPrxHelperBase implements ClientServicePrx
{
    public void
    charge(String depotID, String batteryID, double currentAmount, double useAmount)
        throws OperationError
    {
        charge(depotID, batteryID, currentAmount, useAmount, null, false);
    }

    public void
    charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        charge(depotID, batteryID, currentAmount, useAmount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("charge");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.charge(depotID, batteryID, currentAmount, useAmount, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    closeDepot(String depotID)
        throws OperationError
    {
        closeDepot(depotID, null, false);
    }

    public void
    closeDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        closeDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    closeDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("closeDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.closeDepot(depotID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    closeStation(String stationID)
        throws OperationError
    {
        closeStation(stationID, null, false);
    }

    public void
    closeStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        closeStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    closeStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("closeStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.closeStation(stationID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    discard(String depotID, String batteryID)
        throws OperationError
    {
        discard(depotID, batteryID, null, false);
    }

    public void
    discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        discard(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    discard(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("discard");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.discard(depotID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    moveBatteryFromDepot(String depotID, String batteryID)
        throws OperationError
    {
        moveBatteryFromDepot(depotID, batteryID, null, false);
    }

    public void
    moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        moveBatteryFromDepot(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("moveBatteryFromDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.moveBatteryFromDepot(depotID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    moveBatteryFromStation(String stationID, String batteryID)
        throws OperationError
    {
        moveBatteryFromStation(stationID, batteryID, null, false);
    }

    public void
    moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        moveBatteryFromStation(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("moveBatteryFromStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.moveBatteryFromStation(stationID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    moveBatteryToDepot(String depotID, String batteryID)
        throws OperationError
    {
        moveBatteryToDepot(depotID, batteryID, null, false);
    }

    public void
    moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        moveBatteryToDepot(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("moveBatteryToDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.moveBatteryToDepot(depotID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    moveBatteryToStation(String stationID, String batteryID)
        throws OperationError
    {
        moveBatteryToStation(stationID, batteryID, null, false);
    }

    public void
    moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        moveBatteryToStation(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("moveBatteryToStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.moveBatteryToStation(stationID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    openDepot(String depotID)
        throws OperationError
    {
        openDepot(depotID, null, false);
    }

    public void
    openDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        openDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    openDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("openDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.openDepot(depotID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    openStation(String stationID)
        throws OperationError
    {
        openStation(stationID, null, false);
    }

    public void
    openStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        openStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    openStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("openStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.openStation(stationID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public String
    purchase(BatteryInfo info, double price)
        throws OperationError
    {
        return purchase(info, price, null, false);
    }

    public String
    purchase(BatteryInfo info, double price, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return purchase(info, price, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    purchase(BatteryInfo info, double price, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("purchase");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.purchase(info, price, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public Activity[]
    queryActivities(long start, long end)
    {
        return queryActivities(start, end, null, false);
    }

    public Activity[]
    queryActivities(long start, long end, java.util.Map<String, String> __ctx)
    {
        return queryActivities(start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryActivities(long start, long end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryActivities");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryActivities(start, end, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public BatteryInfo[]
    queryBatteries(BatteryQueryCondition c)
        throws OperationError
    {
        return queryBatteries(c, null, false);
    }

    public BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryBatteries(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryBatteries");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryBatteries(c, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public Activity[]
    queryBatteryActivities(String batteryID, long start, long end)
        throws OperationError
    {
        return queryBatteryActivities(batteryID, start, end, null, false);
    }

    public Activity[]
    queryBatteryActivities(String batteryID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryBatteryActivities(batteryID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryBatteryActivities(String batteryID, long start, long end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryBatteryActivities");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryBatteryActivities(batteryID, start, end, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public Activity[]
    queryDepotActivities(String staionID, long start, long end)
        throws OperationError
    {
        return queryDepotActivities(staionID, start, end, null, false);
    }

    public Activity[]
    queryDepotActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryDepotActivities(staionID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryDepotActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryDepotActivities");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryDepotActivities(staionID, start, end, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public DepotInfo[]
    queryDepots(DepotQueryCondition c)
        throws OperationError
    {
        return queryDepots(c, null, false);
    }

    public DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryDepots(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryDepots");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryDepots(c, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public Activity[]
    queryStationActivities(String staionID, long start, long end)
        throws OperationError
    {
        return queryStationActivities(staionID, start, end, null, false);
    }

    public Activity[]
    queryStationActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryStationActivities(staionID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryStationActivities(String staionID, long start, long end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryStationActivities");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryStationActivities(staionID, start, end, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public StationInfo[]
    queryStations(StationQueryCondition c)
        throws OperationError
    {
        return queryStations(c, null, false);
    }

    public StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryStations(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryStations");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryStations(c, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public VehicleInfo[]
    queryVehicles(VehicleQueryCondition c)
        throws OperationError
    {
        return queryVehicles(c, null, false);
    }

    public VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return queryVehicles(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("queryVehicles");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.queryVehicles(c, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public String
    registerDepot(DepotInfo info)
        throws OperationError
    {
        return registerDepot(info, null, false);
    }

    public String
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return registerDepot(info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("registerDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.registerDepot(info, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public String
    registerStation(StationInfo info)
        throws OperationError
    {
        return registerStation(info, null, false);
    }

    public String
    registerStation(StationInfo info, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return registerStation(info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerStation(StationInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("registerStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.registerStation(info, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public String
    registerVehicle(String stationID, VehicleInfo info)
        throws OperationError
    {
        return registerVehicle(stationID, info, null, false);
    }

    public String
    registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return registerVehicle(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("registerVehicle");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.registerVehicle(stationID, info, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount)
        throws OperationError
    {
        return rentBattery(stationID, vehicleID, batteryID, amount, null, false);
    }

    public double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return rentBattery(stationID, vehicleID, batteryID, amount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("rentBattery");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.rentBattery(stationID, vehicleID, batteryID, amount, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    reportDamagedBattery(String stationID, String batteryID)
        throws OperationError
    {
        reportDamagedBattery(stationID, batteryID, null, false);
    }

    public void
    reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        reportDamagedBattery(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("reportDamagedBattery");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.reportDamagedBattery(stationID, batteryID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public double
    returnBattery(String stationID, String vechildID, String batteryID, double amount)
        throws OperationError
    {
        return returnBattery(stationID, vechildID, batteryID, amount, null, false);
    }

    public double
    returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        return returnBattery(stationID, vechildID, batteryID, amount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private double
    returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("returnBattery");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                return __del.returnBattery(stationID, vechildID, batteryID, amount, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    setDepot(String stationID, DepotInfo info)
        throws OperationError
    {
        setDepot(stationID, info, null, false);
    }

    public void
    setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        setDepot(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("setDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.setDepot(stationID, info, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    setStation(String stationID, StationInfo info)
        throws OperationError
    {
        setStation(stationID, info, null, false);
    }

    public void
    setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        setStation(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("setStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.setStation(stationID, info, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    setUnitChargePrice(double price)
        throws OperationError
    {
        setUnitChargePrice(price, null, false);
    }

    public void
    setUnitChargePrice(double price, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        setUnitChargePrice(price, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setUnitChargePrice(double price, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("setUnitChargePrice");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.setUnitChargePrice(price, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    setUnitPrice(double price)
        throws OperationError
    {
        setUnitPrice(price, null, false);
    }

    public void
    setUnitPrice(double price, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        setUnitPrice(price, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setUnitPrice(double price, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("setUnitPrice");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.setUnitPrice(price, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    unregisterDepot(String depotID)
        throws OperationError
    {
        unregisterDepot(depotID, null, false);
    }

    public void
    unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        unregisterDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    unregisterDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("unregisterDepot");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.unregisterDepot(depotID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public void
    unregisterStation(String stationID)
        throws OperationError
    {
        unregisterStation(stationID, null, false);
    }

    public void
    unregisterStation(String stationID, java.util.Map<String, String> __ctx)
        throws OperationError
    {
        unregisterStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    unregisterStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws OperationError
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("unregisterStation");
                __delBase = __getDelegate();
                _ClientServiceDel __del = (_ClientServiceDel)__delBase;
                __del.unregisterStation(stationID, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, __cnt);
            }
        }
    }

    public static ClientServicePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientServicePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::autoflash::rpc::slice::ClientService"))
                {
                    ClientServicePrxHelper __h = new ClientServicePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientServicePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientServicePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA("::autoflash::rpc::slice::ClientService", __ctx))
                {
                    ClientServicePrxHelper __h = new ClientServicePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientServicePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::autoflash::rpc::slice::ClientService"))
                {
                    ClientServicePrxHelper __h = new ClientServicePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientServicePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA("::autoflash::rpc::slice::ClientService", __ctx))
                {
                    ClientServicePrxHelper __h = new ClientServicePrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientServicePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            ClientServicePrxHelper __h = new ClientServicePrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static ClientServicePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientServicePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ClientServicePrxHelper __h = new ClientServicePrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ClientServiceDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ClientServiceDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ClientServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static ClientServicePrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ClientServicePrxHelper result = new ClientServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}

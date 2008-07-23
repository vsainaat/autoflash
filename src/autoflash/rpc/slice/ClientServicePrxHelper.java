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
    {
        charge(depotID, batteryID, currentAmount, useAmount, null, false);
    }

    public void
    charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx)
    {
        charge(depotID, batteryID, currentAmount, useAmount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    charge(String depotID, String batteryID, double currentAmount, double useAmount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        closeDepot(depotID, null, false);
    }

    public void
    closeDepot(String depotID, java.util.Map<String, String> __ctx)
    {
        closeDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    closeDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        closeStation(stationID, null, false);
    }

    public void
    closeStation(String stationID, java.util.Map<String, String> __ctx)
    {
        closeStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    closeStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        discard(depotID, batteryID, null, false);
    }

    public void
    discard(String depotID, String batteryID, java.util.Map<String, String> __ctx)
    {
        discard(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    discard(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        moveBatteryFromDepot(depotID, batteryID, null, false);
    }

    public void
    moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
    {
        moveBatteryFromDepot(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryFromDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        moveBatteryFromStation(stationID, batteryID, null, false);
    }

    public void
    moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
    {
        moveBatteryFromStation(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryFromStation(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        moveBatteryToDepot(depotID, batteryID, null, false);
    }

    public void
    moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx)
    {
        moveBatteryToDepot(depotID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryToDepot(String depotID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        moveBatteryToStation(stationID, batteryID, null, false);
    }

    public void
    moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx)
    {
        moveBatteryToStation(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    moveBatteryToStation(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        openDepot(depotID, null, false);
    }

    public void
    openDepot(String depotID, java.util.Map<String, String> __ctx)
    {
        openDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    openDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        openStation(stationID, null, false);
    }

    public void
    openStation(String stationID, java.util.Map<String, String> __ctx)
    {
        openStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    openStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    purchase(BatteryInfo info)
    {
        return purchase(info, null, false);
    }

    public String
    purchase(BatteryInfo info, java.util.Map<String, String> __ctx)
    {
        return purchase(info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    purchase(BatteryInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                return __del.purchase(info, __ctx);
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
    queryActivities(int start, int end)
    {
        return queryActivities(start, end, null, false);
    }

    public Activity[]
    queryActivities(int start, int end, java.util.Map<String, String> __ctx)
    {
        return queryActivities(start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryActivities(int start, int end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return queryBatteries(c, null, false);
    }

    public BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx)
    {
        return queryBatteries(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private BatteryInfo[]
    queryBatteries(BatteryQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    queryBatteryActivities(String batteryID, int start, int end)
    {
        return queryBatteryActivities(batteryID, start, end, null, false);
    }

    public Activity[]
    queryBatteryActivities(String batteryID, int start, int end, java.util.Map<String, String> __ctx)
    {
        return queryBatteryActivities(batteryID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryBatteryActivities(String batteryID, int start, int end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    queryDepotActivities(String staionID, int start, int end)
    {
        return queryDepotActivities(staionID, start, end, null, false);
    }

    public Activity[]
    queryDepotActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
    {
        return queryDepotActivities(staionID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryDepotActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return queryDepots(c, null, false);
    }

    public DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx)
    {
        return queryDepots(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private DepotInfo[]
    queryDepots(DepotQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    queryStationActivities(String staionID, int start, int end)
    {
        return queryStationActivities(staionID, start, end, null, false);
    }

    public Activity[]
    queryStationActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx)
    {
        return queryStationActivities(staionID, start, end, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private Activity[]
    queryStationActivities(String staionID, int start, int end, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return queryStations(c, null, false);
    }

    public StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx)
    {
        return queryStations(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private StationInfo[]
    queryStations(StationQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return queryVehicles(c, null, false);
    }

    public VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx)
    {
        return queryVehicles(c, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private VehicleInfo[]
    queryVehicles(VehicleQueryCondition c, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return registerDepot(info, null, false);
    }

    public String
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx)
    {
        return registerDepot(info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerDepot(DepotInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return registerStation(info, null, false);
    }

    public String
    registerStation(StationInfo info, java.util.Map<String, String> __ctx)
    {
        return registerStation(info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerStation(StationInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return registerVehicle(stationID, info, null, false);
    }

    public String
    registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx)
    {
        return registerVehicle(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private String
    registerVehicle(String stationID, VehicleInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return rentBattery(stationID, vehicleID, batteryID, amount, null, false);
    }

    public double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx)
    {
        return rentBattery(stationID, vehicleID, batteryID, amount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private double
    rentBattery(String stationID, String vehicleID, String batteryID, double amount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        reportDamagedBattery(stationID, batteryID, null, false);
    }

    public void
    reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx)
    {
        reportDamagedBattery(stationID, batteryID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    reportDamagedBattery(String stationID, String batteryID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        return returnBattery(stationID, vechildID, batteryID, amount, null, false);
    }

    public double
    returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx)
    {
        return returnBattery(stationID, vechildID, batteryID, amount, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private double
    returnBattery(String stationID, String vechildID, String batteryID, double amount, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        setDepot(stationID, info, null, false);
    }

    public void
    setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx)
    {
        setDepot(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setDepot(String stationID, DepotInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        setStation(stationID, info, null, false);
    }

    public void
    setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx)
    {
        setStation(stationID, info, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    setStation(String stationID, StationInfo info, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    unregisterDepot(String depotID)
    {
        unregisterDepot(depotID, null, false);
    }

    public void
    unregisterDepot(String depotID, java.util.Map<String, String> __ctx)
    {
        unregisterDepot(depotID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    unregisterDepot(String depotID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
    {
        unregisterStation(stationID, null, false);
    }

    public void
    unregisterStation(String stationID, java.util.Map<String, String> __ctx)
    {
        unregisterStation(stationID, __ctx, true);
    }

    @SuppressWarnings("unchecked")
    private void
    unregisterStation(String stationID, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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

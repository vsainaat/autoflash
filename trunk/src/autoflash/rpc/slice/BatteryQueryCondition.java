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

public final class BatteryQueryCondition implements java.lang.Cloneable
{
    public String batteryID;

    public BatteryModel model;

    public BatteryState state;

    public long minShippedDate;

    public long maxShippedDate;

    public int minChargeRounds;

    public int maxChargeRounds;

    public String stationID;

    public String depotID;

    public String vehicleID;

    public BatteryQueryCondition()
    {
    }

    public BatteryQueryCondition(String batteryID, BatteryModel model, BatteryState state, long minShippedDate, long maxShippedDate, int minChargeRounds, int maxChargeRounds, String stationID, String depotID, String vehicleID)
    {
        this.batteryID = batteryID;
        this.model = model;
        this.state = state;
        this.minShippedDate = minShippedDate;
        this.maxShippedDate = maxShippedDate;
        this.minChargeRounds = minChargeRounds;
        this.maxChargeRounds = maxChargeRounds;
        this.stationID = stationID;
        this.depotID = depotID;
        this.vehicleID = vehicleID;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        BatteryQueryCondition _r = null;
        try
        {
            _r = (BatteryQueryCondition)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(batteryID != _r.batteryID && batteryID != null && !batteryID.equals(_r.batteryID))
            {
                return false;
            }
            if(model != _r.model && model != null && !model.equals(_r.model))
            {
                return false;
            }
            if(state != _r.state && state != null && !state.equals(_r.state))
            {
                return false;
            }
            if(minShippedDate != _r.minShippedDate)
            {
                return false;
            }
            if(maxShippedDate != _r.maxShippedDate)
            {
                return false;
            }
            if(minChargeRounds != _r.minChargeRounds)
            {
                return false;
            }
            if(maxChargeRounds != _r.maxChargeRounds)
            {
                return false;
            }
            if(stationID != _r.stationID && stationID != null && !stationID.equals(_r.stationID))
            {
                return false;
            }
            if(depotID != _r.depotID && depotID != null && !depotID.equals(_r.depotID))
            {
                return false;
            }
            if(vehicleID != _r.vehicleID && vehicleID != null && !vehicleID.equals(_r.vehicleID))
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 0;
        if(batteryID != null)
        {
            __h = 5 * __h + batteryID.hashCode();
        }
        __h = 5 * __h + model.hashCode();
        __h = 5 * __h + state.hashCode();
        __h = 5 * __h + (int)minShippedDate;
        __h = 5 * __h + (int)maxShippedDate;
        __h = 5 * __h + minChargeRounds;
        __h = 5 * __h + maxChargeRounds;
        if(stationID != null)
        {
            __h = 5 * __h + stationID.hashCode();
        }
        if(depotID != null)
        {
            __h = 5 * __h + depotID.hashCode();
        }
        if(vehicleID != null)
        {
            __h = 5 * __h + vehicleID.hashCode();
        }
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(batteryID);
        model.__write(__os);
        state.__write(__os);
        __os.writeLong(minShippedDate);
        __os.writeLong(maxShippedDate);
        __os.writeInt(minChargeRounds);
        __os.writeInt(maxChargeRounds);
        __os.writeString(stationID);
        __os.writeString(depotID);
        __os.writeString(vehicleID);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        batteryID = __is.readString();
        model = new BatteryModel();
        model.__read(__is);
        state = BatteryState.__read(__is);
        minShippedDate = __is.readLong();
        maxShippedDate = __is.readLong();
        minChargeRounds = __is.readInt();
        maxChargeRounds = __is.readInt();
        stationID = __is.readString();
        depotID = __is.readString();
        vehicleID = __is.readString();
    }
}

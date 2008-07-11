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
    public BatteryModel model;

    public BatteryStatus status;

    public int minShippedDate;

    public int maxShippedDate;

    public int minChargeRounds;

    public int maxChargeRounds;

    public int stationID;

    public int depotID;

    public int vehicleID;

    public BatteryQueryCondition()
    {
    }

    public BatteryQueryCondition(BatteryModel model, BatteryStatus status, int minShippedDate, int maxShippedDate, int minChargeRounds, int maxChargeRounds, int stationID, int depotID, int vehicleID)
    {
        this.model = model;
        this.status = status;
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
            if(model != _r.model && model != null && !model.equals(_r.model))
            {
                return false;
            }
            if(status != _r.status && status != null && !status.equals(_r.status))
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
            if(stationID != _r.stationID)
            {
                return false;
            }
            if(depotID != _r.depotID)
            {
                return false;
            }
            if(vehicleID != _r.vehicleID)
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
        __h = 5 * __h + model.hashCode();
        __h = 5 * __h + status.hashCode();
        __h = 5 * __h + minShippedDate;
        __h = 5 * __h + maxShippedDate;
        __h = 5 * __h + minChargeRounds;
        __h = 5 * __h + maxChargeRounds;
        __h = 5 * __h + stationID;
        __h = 5 * __h + depotID;
        __h = 5 * __h + vehicleID;
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
        model.__write(__os);
        status.__write(__os);
        __os.writeInt(minShippedDate);
        __os.writeInt(maxShippedDate);
        __os.writeInt(minChargeRounds);
        __os.writeInt(maxChargeRounds);
        __os.writeInt(stationID);
        __os.writeInt(depotID);
        __os.writeInt(vehicleID);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        model = new BatteryModel();
        model.__read(__is);
        status = BatteryStatus.__read(__is);
        minShippedDate = __is.readInt();
        maxShippedDate = __is.readInt();
        minChargeRounds = __is.readInt();
        maxChargeRounds = __is.readInt();
        stationID = __is.readInt();
        depotID = __is.readInt();
        vehicleID = __is.readInt();
    }
}

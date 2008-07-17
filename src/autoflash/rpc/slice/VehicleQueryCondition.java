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

public final class VehicleQueryCondition implements java.lang.Cloneable
{
    public String model;

    public int minChargeDate;

    public int maxChargeDate;

    public int batteryNum;

    public String batteryID;

    public VehicleQueryCondition()
    {
    }

    public VehicleQueryCondition(String model, int minChargeDate, int maxChargeDate, int batteryNum, String batteryID)
    {
        this.model = model;
        this.minChargeDate = minChargeDate;
        this.maxChargeDate = maxChargeDate;
        this.batteryNum = batteryNum;
        this.batteryID = batteryID;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        VehicleQueryCondition _r = null;
        try
        {
            _r = (VehicleQueryCondition)rhs;
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
            if(minChargeDate != _r.minChargeDate)
            {
                return false;
            }
            if(maxChargeDate != _r.maxChargeDate)
            {
                return false;
            }
            if(batteryNum != _r.batteryNum)
            {
                return false;
            }
            if(batteryID != _r.batteryID && batteryID != null && !batteryID.equals(_r.batteryID))
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
        if(model != null)
        {
            __h = 5 * __h + model.hashCode();
        }
        __h = 5 * __h + minChargeDate;
        __h = 5 * __h + maxChargeDate;
        __h = 5 * __h + batteryNum;
        if(batteryID != null)
        {
            __h = 5 * __h + batteryID.hashCode();
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
        __os.writeString(model);
        __os.writeInt(minChargeDate);
        __os.writeInt(maxChargeDate);
        __os.writeInt(batteryNum);
        __os.writeString(batteryID);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        model = __is.readString();
        minChargeDate = __is.readInt();
        maxChargeDate = __is.readInt();
        batteryNum = __is.readInt();
        batteryID = __is.readString();
    }
}

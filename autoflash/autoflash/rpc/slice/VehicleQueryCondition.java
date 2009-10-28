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

    public long minChargeDate;

    public long maxChargeDate;

    public int batteryNum;

    public String batteryID;

    public String license;

    public String vehicleID;

    public String owner;

    public VehicleQueryCondition()
    {
    }

    public VehicleQueryCondition(String model, long minChargeDate, long maxChargeDate, int batteryNum, String batteryID, String license, String vehicleID, String owner)
    {
        this.model = model;
        this.minChargeDate = minChargeDate;
        this.maxChargeDate = maxChargeDate;
        this.batteryNum = batteryNum;
        this.batteryID = batteryID;
        this.license = license;
        this.vehicleID = vehicleID;
        this.owner = owner;
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
            if(license != _r.license && license != null && !license.equals(_r.license))
            {
                return false;
            }
            if(vehicleID != _r.vehicleID && vehicleID != null && !vehicleID.equals(_r.vehicleID))
            {
                return false;
            }
            if(owner != _r.owner && owner != null && !owner.equals(_r.owner))
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
        __h = 5 * __h + (int)minChargeDate;
        __h = 5 * __h + (int)maxChargeDate;
        __h = 5 * __h + batteryNum;
        if(batteryID != null)
        {
            __h = 5 * __h + batteryID.hashCode();
        }
        if(license != null)
        {
            __h = 5 * __h + license.hashCode();
        }
        if(vehicleID != null)
        {
            __h = 5 * __h + vehicleID.hashCode();
        }
        if(owner != null)
        {
            __h = 5 * __h + owner.hashCode();
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
        __os.writeLong(minChargeDate);
        __os.writeLong(maxChargeDate);
        __os.writeInt(batteryNum);
        __os.writeString(batteryID);
        __os.writeString(license);
        __os.writeString(vehicleID);
        __os.writeString(owner);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        model = __is.readString();
        minChargeDate = __is.readLong();
        maxChargeDate = __is.readLong();
        batteryNum = __is.readInt();
        batteryID = __is.readString();
        license = __is.readString();
        vehicleID = __is.readString();
        owner = __is.readString();
    }
}

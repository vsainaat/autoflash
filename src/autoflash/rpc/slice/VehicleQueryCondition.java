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
    public String factory;

    public int minChangeDate;

    public int maxChangeDate;

    public int batteryNum;

    public VehicleQueryCondition()
    {
    }

    public VehicleQueryCondition(String factory, int minChangeDate, int maxChangeDate, int batteryNum)
    {
        this.factory = factory;
        this.minChangeDate = minChangeDate;
        this.maxChangeDate = maxChangeDate;
        this.batteryNum = batteryNum;
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
            if(factory != _r.factory && factory != null && !factory.equals(_r.factory))
            {
                return false;
            }
            if(minChangeDate != _r.minChangeDate)
            {
                return false;
            }
            if(maxChangeDate != _r.maxChangeDate)
            {
                return false;
            }
            if(batteryNum != _r.batteryNum)
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
        if(factory != null)
        {
            __h = 5 * __h + factory.hashCode();
        }
        __h = 5 * __h + minChangeDate;
        __h = 5 * __h + maxChangeDate;
        __h = 5 * __h + batteryNum;
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
        __os.writeString(factory);
        __os.writeInt(minChangeDate);
        __os.writeInt(maxChangeDate);
        __os.writeInt(batteryNum);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        factory = __is.readString();
        minChangeDate = __is.readInt();
        maxChangeDate = __is.readInt();
        batteryNum = __is.readInt();
    }
}

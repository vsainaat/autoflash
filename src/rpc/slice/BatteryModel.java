// **********************************************************************
//
// Copyright (c) 2003-2007 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.2.1

package rpc.slice;

public final class BatteryModel implements java.lang.Cloneable
{
    public String name;

    public int maxChargeRounds;

    public double capacity;

    public int maxLifeTime;

    public String factory;

    public BatteryModel()
    {
    }

    public BatteryModel(String name, int maxChargeRounds, double capacity, int maxLifeTime, String factory)
    {
        this.name = name;
        this.maxChargeRounds = maxChargeRounds;
        this.capacity = capacity;
        this.maxLifeTime = maxLifeTime;
        this.factory = factory;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        BatteryModel _r = null;
        try
        {
            _r = (BatteryModel)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(name != _r.name && name != null && !name.equals(_r.name))
            {
                return false;
            }
            if(maxChargeRounds != _r.maxChargeRounds)
            {
                return false;
            }
            if(capacity != _r.capacity)
            {
                return false;
            }
            if(maxLifeTime != _r.maxLifeTime)
            {
                return false;
            }
            if(factory != _r.factory && factory != null && !factory.equals(_r.factory))
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
        if(name != null)
        {
            __h = 5 * __h + name.hashCode();
        }
        __h = 5 * __h + maxChargeRounds;
        __h = 5 * __h + (int)java.lang.Double.doubleToLongBits(capacity);
        __h = 5 * __h + maxLifeTime;
        if(factory != null)
        {
            __h = 5 * __h + factory.hashCode();
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
        __os.writeString(name);
        __os.writeInt(maxChargeRounds);
        __os.writeDouble(capacity);
        __os.writeInt(maxLifeTime);
        __os.writeString(factory);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        name = __is.readString();
        maxChargeRounds = __is.readInt();
        capacity = __is.readDouble();
        maxLifeTime = __is.readInt();
        factory = __is.readString();
    }
}

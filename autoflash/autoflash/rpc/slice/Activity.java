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

public final class Activity implements java.lang.Cloneable
{
    public long time;

    public ActivityType type;

    public String batteryID;

    public String vehicleID;

    public String stationOrDepotID;

    public double price;

    public Activity()
    {
    }

    public Activity(long time, ActivityType type, String batteryID, String vehicleID, String stationOrDepotID, double price)
    {
        this.time = time;
        this.type = type;
        this.batteryID = batteryID;
        this.vehicleID = vehicleID;
        this.stationOrDepotID = stationOrDepotID;
        this.price = price;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Activity _r = null;
        try
        {
            _r = (Activity)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(time != _r.time)
            {
                return false;
            }
            if(type != _r.type && type != null && !type.equals(_r.type))
            {
                return false;
            }
            if(batteryID != _r.batteryID && batteryID != null && !batteryID.equals(_r.batteryID))
            {
                return false;
            }
            if(vehicleID != _r.vehicleID && vehicleID != null && !vehicleID.equals(_r.vehicleID))
            {
                return false;
            }
            if(stationOrDepotID != _r.stationOrDepotID && stationOrDepotID != null && !stationOrDepotID.equals(_r.stationOrDepotID))
            {
                return false;
            }
            if(price != _r.price)
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
        __h = 5 * __h + (int)time;
        __h = 5 * __h + type.hashCode();
        if(batteryID != null)
        {
            __h = 5 * __h + batteryID.hashCode();
        }
        if(vehicleID != null)
        {
            __h = 5 * __h + vehicleID.hashCode();
        }
        if(stationOrDepotID != null)
        {
            __h = 5 * __h + stationOrDepotID.hashCode();
        }
        __h = 5 * __h + (int)java.lang.Double.doubleToLongBits(price);
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
        __os.writeLong(time);
        type.__write(__os);
        __os.writeString(batteryID);
        __os.writeString(vehicleID);
        __os.writeString(stationOrDepotID);
        __os.writeDouble(price);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        time = __is.readLong();
        type = ActivityType.__read(__is);
        batteryID = __is.readString();
        vehicleID = __is.readString();
        stationOrDepotID = __is.readString();
        price = __is.readDouble();
    }
}

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
    public ActivityType type;

    public String batteryID;

    public String stationOrDepotID;

    public int money;

    public Activity()
    {
    }

    public Activity(ActivityType type, String batteryID, String stationOrDepotID, int money)
    {
        this.type = type;
        this.batteryID = batteryID;
        this.stationOrDepotID = stationOrDepotID;
        this.money = money;
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
            if(type != _r.type && type != null && !type.equals(_r.type))
            {
                return false;
            }
            if(batteryID != _r.batteryID && batteryID != null && !batteryID.equals(_r.batteryID))
            {
                return false;
            }
            if(stationOrDepotID != _r.stationOrDepotID && stationOrDepotID != null && !stationOrDepotID.equals(_r.stationOrDepotID))
            {
                return false;
            }
            if(money != _r.money)
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
        __h = 5 * __h + type.hashCode();
        if(batteryID != null)
        {
            __h = 5 * __h + batteryID.hashCode();
        }
        if(stationOrDepotID != null)
        {
            __h = 5 * __h + stationOrDepotID.hashCode();
        }
        __h = 5 * __h + money;
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
        type.__write(__os);
        __os.writeString(batteryID);
        __os.writeString(stationOrDepotID);
        __os.writeInt(money);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        type = ActivityType.__read(__is);
        batteryID = __is.readString();
        stationOrDepotID = __is.readString();
        money = __is.readInt();
    }
}

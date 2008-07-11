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

public final class StationQueryCondition implements java.lang.Cloneable
{
    public Area addr;

    public int stationID;

    public boolean open;

    public String owner;

    public int minCapacity;

    public int maxCapacity;

    public StationQueryCondition()
    {
    }

    public StationQueryCondition(Area addr, int stationID, boolean open, String owner, int minCapacity, int maxCapacity)
    {
        this.addr = addr;
        this.stationID = stationID;
        this.open = open;
        this.owner = owner;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        StationQueryCondition _r = null;
        try
        {
            _r = (StationQueryCondition)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(addr != _r.addr && addr != null && !addr.equals(_r.addr))
            {
                return false;
            }
            if(stationID != _r.stationID)
            {
                return false;
            }
            if(open != _r.open)
            {
                return false;
            }
            if(owner != _r.owner && owner != null && !owner.equals(_r.owner))
            {
                return false;
            }
            if(minCapacity != _r.minCapacity)
            {
                return false;
            }
            if(maxCapacity != _r.maxCapacity)
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
        __h = 5 * __h + addr.hashCode();
        __h = 5 * __h + stationID;
        __h = 5 * __h + (open ? 1 : 0);
        if(owner != null)
        {
            __h = 5 * __h + owner.hashCode();
        }
        __h = 5 * __h + minCapacity;
        __h = 5 * __h + maxCapacity;
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
        addr.__write(__os);
        __os.writeInt(stationID);
        __os.writeBool(open);
        __os.writeString(owner);
        __os.writeInt(minCapacity);
        __os.writeInt(maxCapacity);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        addr = new Area();
        addr.__read(__is);
        stationID = __is.readInt();
        open = __is.readBool();
        owner = __is.readString();
        minCapacity = __is.readInt();
        maxCapacity = __is.readInt();
    }
}

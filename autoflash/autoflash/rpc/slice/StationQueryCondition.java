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
    public Area region;

    public String stationID;

    public OpenStatus status;

    public String owner;

    public int minCapacity;

    public int maxCapacity;

    public StationQueryCondition()
    {
    }

    public StationQueryCondition(Area region, String stationID, OpenStatus status, String owner, int minCapacity, int maxCapacity)
    {
        this.region = region;
        this.stationID = stationID;
        this.status = status;
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
            if(region != _r.region && region != null && !region.equals(_r.region))
            {
                return false;
            }
            if(stationID != _r.stationID && stationID != null && !stationID.equals(_r.stationID))
            {
                return false;
            }
            if(status != _r.status && status != null && !status.equals(_r.status))
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
        __h = 5 * __h + region.hashCode();
        if(stationID != null)
        {
            __h = 5 * __h + stationID.hashCode();
        }
        __h = 5 * __h + status.hashCode();
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
        region.__write(__os);
        __os.writeString(stationID);
        status.__write(__os);
        __os.writeString(owner);
        __os.writeInt(minCapacity);
        __os.writeInt(maxCapacity);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        region = new Area();
        region.__read(__is);
        stationID = __is.readString();
        status = OpenStatus.__read(__is);
        owner = __is.readString();
        minCapacity = __is.readInt();
        maxCapacity = __is.readInt();
    }
}

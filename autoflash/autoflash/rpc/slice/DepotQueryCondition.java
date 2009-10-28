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

public final class DepotQueryCondition implements java.lang.Cloneable
{
    public Area region;

    public String depotID;

    public OpenStatus status;

    public String owner;

    public int minStorageCapacity;

    public int maxStorageCapacity;

    public int minChargeCapacity;

    public int maxChargeCapacity;

    public DepotQueryCondition()
    {
    }

    public DepotQueryCondition(Area region, String depotID, OpenStatus status, String owner, int minStorageCapacity, int maxStorageCapacity, int minChargeCapacity, int maxChargeCapacity)
    {
        this.region = region;
        this.depotID = depotID;
        this.status = status;
        this.owner = owner;
        this.minStorageCapacity = minStorageCapacity;
        this.maxStorageCapacity = maxStorageCapacity;
        this.minChargeCapacity = minChargeCapacity;
        this.maxChargeCapacity = maxChargeCapacity;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        DepotQueryCondition _r = null;
        try
        {
            _r = (DepotQueryCondition)rhs;
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
            if(depotID != _r.depotID && depotID != null && !depotID.equals(_r.depotID))
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
            if(minStorageCapacity != _r.minStorageCapacity)
            {
                return false;
            }
            if(maxStorageCapacity != _r.maxStorageCapacity)
            {
                return false;
            }
            if(minChargeCapacity != _r.minChargeCapacity)
            {
                return false;
            }
            if(maxChargeCapacity != _r.maxChargeCapacity)
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
        if(depotID != null)
        {
            __h = 5 * __h + depotID.hashCode();
        }
        __h = 5 * __h + status.hashCode();
        if(owner != null)
        {
            __h = 5 * __h + owner.hashCode();
        }
        __h = 5 * __h + minStorageCapacity;
        __h = 5 * __h + maxStorageCapacity;
        __h = 5 * __h + minChargeCapacity;
        __h = 5 * __h + maxChargeCapacity;
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
        __os.writeString(depotID);
        status.__write(__os);
        __os.writeString(owner);
        __os.writeInt(minStorageCapacity);
        __os.writeInt(maxStorageCapacity);
        __os.writeInt(minChargeCapacity);
        __os.writeInt(maxChargeCapacity);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        region = new Area();
        region.__read(__is);
        depotID = __is.readString();
        status = OpenStatus.__read(__is);
        owner = __is.readString();
        minStorageCapacity = __is.readInt();
        maxStorageCapacity = __is.readInt();
        minChargeCapacity = __is.readInt();
        maxChargeCapacity = __is.readInt();
    }
}

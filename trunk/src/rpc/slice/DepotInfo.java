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

public final class DepotInfo implements java.lang.Cloneable
{
    public int ID;

    public Address addr;

    public double chargePrice;

    public int storageCapacity;

    public int chargeCapacity;

    public String owner;

    public int rentPrice;

    public DepotInfo()
    {
    }

    public DepotInfo(int ID, Address addr, double chargePrice, int storageCapacity, int chargeCapacity, String owner, int rentPrice)
    {
        this.ID = ID;
        this.addr = addr;
        this.chargePrice = chargePrice;
        this.storageCapacity = storageCapacity;
        this.chargeCapacity = chargeCapacity;
        this.owner = owner;
        this.rentPrice = rentPrice;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        DepotInfo _r = null;
        try
        {
            _r = (DepotInfo)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(ID != _r.ID)
            {
                return false;
            }
            if(addr != _r.addr && addr != null && !addr.equals(_r.addr))
            {
                return false;
            }
            if(chargePrice != _r.chargePrice)
            {
                return false;
            }
            if(storageCapacity != _r.storageCapacity)
            {
                return false;
            }
            if(chargeCapacity != _r.chargeCapacity)
            {
                return false;
            }
            if(owner != _r.owner && owner != null && !owner.equals(_r.owner))
            {
                return false;
            }
            if(rentPrice != _r.rentPrice)
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
        __h = 5 * __h + ID;
        __h = 5 * __h + addr.hashCode();
        __h = 5 * __h + (int)java.lang.Double.doubleToLongBits(chargePrice);
        __h = 5 * __h + storageCapacity;
        __h = 5 * __h + chargeCapacity;
        if(owner != null)
        {
            __h = 5 * __h + owner.hashCode();
        }
        __h = 5 * __h + rentPrice;
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
        __os.writeInt(ID);
        addr.__write(__os);
        __os.writeDouble(chargePrice);
        __os.writeInt(storageCapacity);
        __os.writeInt(chargeCapacity);
        __os.writeString(owner);
        __os.writeInt(rentPrice);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        ID = __is.readInt();
        addr = new Address();
        addr.__read(__is);
        chargePrice = __is.readDouble();
        storageCapacity = __is.readInt();
        chargeCapacity = __is.readInt();
        owner = __is.readString();
        rentPrice = __is.readInt();
    }
}

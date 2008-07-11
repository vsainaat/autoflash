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

public final class BatteryInfo implements java.lang.Cloneable
{
    public int ID;

    public BatteryModel model;

    public int shippedDate;

    public int chargeRounds;

    public BatteryInfo()
    {
    }

    public BatteryInfo(int ID, BatteryModel model, int shippedDate, int chargeRounds)
    {
        this.ID = ID;
        this.model = model;
        this.shippedDate = shippedDate;
        this.chargeRounds = chargeRounds;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        BatteryInfo _r = null;
        try
        {
            _r = (BatteryInfo)rhs;
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
            if(model != _r.model && model != null && !model.equals(_r.model))
            {
                return false;
            }
            if(shippedDate != _r.shippedDate)
            {
                return false;
            }
            if(chargeRounds != _r.chargeRounds)
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
        __h = 5 * __h + model.hashCode();
        __h = 5 * __h + shippedDate;
        __h = 5 * __h + chargeRounds;
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
        model.__write(__os);
        __os.writeInt(shippedDate);
        __os.writeInt(chargeRounds);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        ID = __is.readInt();
        model = new BatteryModel();
        model.__read(__is);
        shippedDate = __is.readInt();
        chargeRounds = __is.readInt();
    }
}

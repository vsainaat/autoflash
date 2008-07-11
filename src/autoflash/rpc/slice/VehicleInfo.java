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

public final class VehicleInfo implements java.lang.Cloneable
{
    public int ID;

    public String code;

    public String model;

    public VehicleInfo()
    {
    }

    public VehicleInfo(int ID, String code, String model)
    {
        this.ID = ID;
        this.code = code;
        this.model = model;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        VehicleInfo _r = null;
        try
        {
            _r = (VehicleInfo)rhs;
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
            if(code != _r.code && code != null && !code.equals(_r.code))
            {
                return false;
            }
            if(model != _r.model && model != null && !model.equals(_r.model))
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
        if(code != null)
        {
            __h = 5 * __h + code.hashCode();
        }
        if(model != null)
        {
            __h = 5 * __h + model.hashCode();
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
        __os.writeInt(ID);
        __os.writeString(code);
        __os.writeString(model);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        ID = __is.readInt();
        code = __is.readString();
        model = __is.readString();
    }
}

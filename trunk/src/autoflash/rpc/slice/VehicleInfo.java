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
    public String ID;

    public String licence;

    public String owner;

    public String model;

    public VehicleInfo()
    {
    }

    public VehicleInfo(String ID, String licence, String owner, String model)
    {
        this.ID = ID;
        this.licence = licence;
        this.owner = owner;
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
            if(ID != _r.ID && ID != null && !ID.equals(_r.ID))
            {
                return false;
            }
            if(licence != _r.licence && licence != null && !licence.equals(_r.licence))
            {
                return false;
            }
            if(owner != _r.owner && owner != null && !owner.equals(_r.owner))
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
        if(ID != null)
        {
            __h = 5 * __h + ID.hashCode();
        }
        if(licence != null)
        {
            __h = 5 * __h + licence.hashCode();
        }
        if(owner != null)
        {
            __h = 5 * __h + owner.hashCode();
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
        __os.writeString(ID);
        __os.writeString(licence);
        __os.writeString(owner);
        __os.writeString(model);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        ID = __is.readString();
        licence = __is.readString();
        owner = __is.readString();
        model = __is.readString();
    }
}

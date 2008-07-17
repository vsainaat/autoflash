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

public final class Point implements java.lang.Cloneable
{
    public int latitude;

    public int longitude;

    public Point()
    {
    }

    public Point(int latitude, int longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Point _r = null;
        try
        {
            _r = (Point)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(latitude != _r.latitude)
            {
                return false;
            }
            if(longitude != _r.longitude)
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
        __h = 5 * __h + latitude;
        __h = 5 * __h + longitude;
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
        __os.writeInt(latitude);
        __os.writeInt(longitude);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        latitude = __is.readInt();
        longitude = __is.readInt();
    }
}

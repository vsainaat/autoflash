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

public final class Area implements java.lang.Cloneable
{
    public Point topLeftCorner;

    public int latitudeSpan;

    public int longitudeSpan;

    public Area()
    {
    }

    public Area(Point topLeftCorner, int latitudeSpan, int longitudeSpan)
    {
        this.topLeftCorner = topLeftCorner;
        this.latitudeSpan = latitudeSpan;
        this.longitudeSpan = longitudeSpan;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Area _r = null;
        try
        {
            _r = (Area)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(topLeftCorner != _r.topLeftCorner && topLeftCorner != null && !topLeftCorner.equals(_r.topLeftCorner))
            {
                return false;
            }
            if(latitudeSpan != _r.latitudeSpan)
            {
                return false;
            }
            if(longitudeSpan != _r.longitudeSpan)
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
        __h = 5 * __h + topLeftCorner.hashCode();
        __h = 5 * __h + latitudeSpan;
        __h = 5 * __h + longitudeSpan;
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
        topLeftCorner.__write(__os);
        __os.writeInt(latitudeSpan);
        __os.writeInt(longitudeSpan);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        topLeftCorner = new Point();
        topLeftCorner.__read(__is);
        latitudeSpan = __is.readInt();
        longitudeSpan = __is.readInt();
    }
}

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

public final class Area implements java.lang.Cloneable
{
    public int xmin;

    public int xmax;

    public int ymin;

    public int ymax;

    public Area()
    {
    }

    public Area(int xmin, int xmax, int ymin, int ymax)
    {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
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
            if(xmin != _r.xmin)
            {
                return false;
            }
            if(xmax != _r.xmax)
            {
                return false;
            }
            if(ymin != _r.ymin)
            {
                return false;
            }
            if(ymax != _r.ymax)
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
        __h = 5 * __h + xmin;
        __h = 5 * __h + xmax;
        __h = 5 * __h + ymin;
        __h = 5 * __h + ymax;
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
        __os.writeInt(xmin);
        __os.writeInt(xmax);
        __os.writeInt(ymin);
        __os.writeInt(ymax);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        xmin = __is.readInt();
        xmax = __is.readInt();
        ymin = __is.readInt();
        ymax = __is.readInt();
    }
}

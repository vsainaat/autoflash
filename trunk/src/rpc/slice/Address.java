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

public final class Address implements java.lang.Cloneable
{
    public int x;

    public int y;

    public Address()
    {
    }

    public Address(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Address _r = null;
        try
        {
            _r = (Address)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(x != _r.x)
            {
                return false;
            }
            if(y != _r.y)
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
        __h = 5 * __h + x;
        __h = 5 * __h + y;
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
        __os.writeInt(x);
        __os.writeInt(y);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        x = __is.readInt();
        y = __is.readInt();
    }
}

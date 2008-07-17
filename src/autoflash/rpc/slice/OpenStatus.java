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

public enum OpenStatus
{
    Open(0),
    Closed(1),
    OpenOrClosed(2);

    private static OpenStatus[] __values = new OpenStatus[3];
    static
    {
        __values[0] = Open;
        __values[1] = Closed;
        __values[2] = OpenOrClosed;
    }
    private int __value;

    public static final int _Open = 0;
    public static final int _Closed = 1;
    public static final int _OpenOrClosed = 2;

    public static OpenStatus
    convert(int val)
    {
        assert val < 3;
        return __values[val];
    }

    public static OpenStatus
    convert(String val)
    {
        for(int __i = 0; __i < __values.length; ++__i)
        {
            if(__values[__i].toString().equals(val))
            {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public int
    value()
    {
        return __value;
    }

    private
    OpenStatus(int val)
    {
        __value = val;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)__value);
    }

    public static OpenStatus
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte();
        if(__v < 0 || __v >= 3)
        {
            throw new Ice.MarshalException();
        }
        return OpenStatus.convert(__v);
    }
}

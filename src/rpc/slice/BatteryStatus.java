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

public enum BatteryStatus
{
    Shipped(0),
    Storage(1),
    Charging(2),
    Onboard(3),
    Discarded(4),
    Arbitrary(5);

    private static BatteryStatus[] __values = new BatteryStatus[6];
    static
    {
        __values[0] = Shipped;
        __values[1] = Storage;
        __values[2] = Charging;
        __values[3] = Onboard;
        __values[4] = Discarded;
        __values[5] = Arbitrary;
    }
    private int __value;

    public static final int _Shipped = 0;
    public static final int _Storage = 1;
    public static final int _Charging = 2;
    public static final int _Onboard = 3;
    public static final int _Discarded = 4;
    public static final int _Arbitrary = 5;

    public static BatteryStatus
    convert(int val)
    {
        assert val < 6;
        return __values[val];
    }

    public static BatteryStatus
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
    BatteryStatus(int val)
    {
        __value = val;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)__value);
    }

    public static BatteryStatus
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte();
        if(__v < 0 || __v >= 6)
        {
            throw new Ice.MarshalException();
        }
        return BatteryStatus.convert(__v);
    }
}

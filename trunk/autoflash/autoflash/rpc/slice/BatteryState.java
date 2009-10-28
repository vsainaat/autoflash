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

public enum BatteryState
{
    Empty(0),
    Charging(1),
    Charged(2),
    Onboard(3),
    Discarded(4),
    Arbitrary(5);

    private static BatteryState[] __values = new BatteryState[6];
    static
    {
        __values[0] = Empty;
        __values[1] = Charging;
        __values[2] = Charged;
        __values[3] = Onboard;
        __values[4] = Discarded;
        __values[5] = Arbitrary;
    }
    private int __value;

    public static final int _Empty = 0;
    public static final int _Charging = 1;
    public static final int _Charged = 2;
    public static final int _Onboard = 3;
    public static final int _Discarded = 4;
    public static final int _Arbitrary = 5;

    public static BatteryState
    convert(int val)
    {
        assert val < 6;
        return __values[val];
    }

    public static BatteryState
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
    BatteryState(int val)
    {
        __value = val;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)__value);
    }

    public static BatteryState
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte();
        if(__v < 0 || __v >= 6)
        {
            throw new Ice.MarshalException();
        }
        return BatteryState.convert(__v);
    }
}

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

public enum ActivityType
{
    Rent(0),
    Return(1),
    MoveFromStation(2),
    MoveToStation(3),
    MoveFromDepot(4),
    MoveToDepot(5),
    Purchase(6),
    Discard(7),
    OpenStation(8),
    CloseStation(9),
    OpenDepot(10),
    CloseDepot(11),
    Register(12),
    Unregister(13),
    Set(14),
    Charge(15);

    private static ActivityType[] __values = new ActivityType[16];
    static
    {
        __values[0] = Rent;
        __values[1] = Return;
        __values[2] = MoveFromStation;
        __values[3] = MoveToStation;
        __values[4] = MoveFromDepot;
        __values[5] = MoveToDepot;
        __values[6] = Purchase;
        __values[7] = Discard;
        __values[8] = OpenStation;
        __values[9] = CloseStation;
        __values[10] = OpenDepot;
        __values[11] = CloseDepot;
        __values[12] = Register;
        __values[13] = Unregister;
        __values[14] = Set;
        __values[15] = Charge;
    }
    private int __value;

    public static final int _Rent = 0;
    public static final int _Return = 1;
    public static final int _MoveFromStation = 2;
    public static final int _MoveToStation = 3;
    public static final int _MoveFromDepot = 4;
    public static final int _MoveToDepot = 5;
    public static final int _Purchase = 6;
    public static final int _Discard = 7;
    public static final int _OpenStation = 8;
    public static final int _CloseStation = 9;
    public static final int _OpenDepot = 10;
    public static final int _CloseDepot = 11;
    public static final int _Register = 12;
    public static final int _Unregister = 13;
    public static final int _Set = 14;
    public static final int _Charge = 15;

    public static ActivityType
    convert(int val)
    {
        assert val < 16;
        return __values[val];
    }

    public static ActivityType
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
    ActivityType(int val)
    {
        __value = val;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)__value);
    }

    public static ActivityType
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte();
        if(__v < 0 || __v >= 16)
        {
            throw new Ice.MarshalException();
        }
        return ActivityType.convert(__v);
    }
}

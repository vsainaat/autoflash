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

public enum ActivityType
{
    Rent(0),
    Return(1),
    MoveFromStation(2),
    MoveToStation(3),
    MoveFromDepot(4),
    MoveInDepot(5),
    Purchase(6),
    Discard(7),
    Open(8),
    Close(9),
    Register(10),
    Unregister(11),
    Set(12),
    Charge(13);

    private static ActivityType[] __values = new ActivityType[14];
    static
    {
        __values[0] = Rent;
        __values[1] = Return;
        __values[2] = MoveFromStation;
        __values[3] = MoveToStation;
        __values[4] = MoveFromDepot;
        __values[5] = MoveInDepot;
        __values[6] = Purchase;
        __values[7] = Discard;
        __values[8] = Open;
        __values[9] = Close;
        __values[10] = Register;
        __values[11] = Unregister;
        __values[12] = Set;
        __values[13] = Charge;
    }
    private int __value;

    public static final int _Rent = 0;
    public static final int _Return = 1;
    public static final int _MoveFromStation = 2;
    public static final int _MoveToStation = 3;
    public static final int _MoveFromDepot = 4;
    public static final int _MoveInDepot = 5;
    public static final int _Purchase = 6;
    public static final int _Discard = 7;
    public static final int _Open = 8;
    public static final int _Close = 9;
    public static final int _Register = 10;
    public static final int _Unregister = 11;
    public static final int _Set = 12;
    public static final int _Charge = 13;

    public static ActivityType
    convert(int val)
    {
        assert val < 14;
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
        if(__v < 0 || __v >= 14)
        {
            throw new Ice.MarshalException();
        }
        return ActivityType.convert(__v);
    }
}

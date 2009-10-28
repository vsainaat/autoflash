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

public class GenericError extends Ice.UserException
{
    public GenericError()
    {
    }

    public GenericError(String reason)
    {
        this.reason = reason;
    }

    public String
    ice_name()
    {
        return "autoflash::rpc::slice::GenericError";
    }

    public String reason;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString("::autoflash::rpc::slice::GenericError");
        __os.startWriteSlice();
        __os.writeString(reason);
        __os.endWriteSlice();
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readString();
        }
        __is.startReadSlice();
        reason = __is.readString();
        __is.endReadSlice();
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception autoflash::rpc::slice::GenericError was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception autoflash::rpc::slice::GenericError was not generated with stream support";
        throw ex;
    }
}

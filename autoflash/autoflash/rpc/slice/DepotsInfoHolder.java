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

public final class DepotsInfoHolder
{
    public
    DepotsInfoHolder()
    {
    }

    public
    DepotsInfoHolder(DepotInfo[] value)
    {
        this.value = value;
    }

    public DepotInfo[] value;
}

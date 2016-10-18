package com.danny.devframework.network.request;

import com.danny.devframework.network.RequestCallbacks;

/**
 * Created by danny on 10/18/16.
 */

public class BaseRequest {
    private RequestType         mType;
    private RequestCallbacks    mCallbacks;

    protected BaseRequest(RequestType aType, RequestCallbacks aCallbacks)
    {
        mCallbacks = aCallbacks;
    }

    public void execute()
    {

    }

    
}

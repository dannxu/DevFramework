package com.danny.devframework.utils;

import android.os.Message;

/**
 * Created by danny on 10/17/16.
 */

public class DataCallbacksUtils extends ThreadUtils{
    private static DataCallbacksUtils sInstance;

    private DataCallbacksUtils()
    {
        super();
    }

    public static DataCallbacksUtils getInstance()
    {
        if (sInstance == null)
        {
            synchronized (DataCallbacksUtils.class)
            {
                sInstance = new DataCallbacksUtils();
            }
        }

        return sInstance;
    }

    @Override
    protected void execute(Message aMessage) {

    }
}

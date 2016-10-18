package com.danny.devframework.helpers;

/**
 * Created by apple on 16/10/18.
 */

public class DataHelper
{
    private static final String TAG = "DataHelper";

    private static DataHelper sInstance = null;
    private DataHelper()
    {

    }

    public static DataHelper getInstance()
    {
        if (sInstance == null)
        {
            synchronized (DataHelper.class)
            {
                if (sInstance == null)
                {
                    sInstance = new DataHelper();
                }
            }
        }

        return sInstance;
    }
}

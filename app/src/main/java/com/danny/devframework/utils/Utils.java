package com.danny.devframework.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by danny on 10/14/16.
 */

public class Utils {
    public static final String TAG = "Utils";
    public static String logStringCache = "";

    public static String getMetaValue(Context aContext, String aMetaKey)
    {
        if (aContext == null || aMetaKey == null)
        {
            return null;
        }
        Bundle metaData = null;
        String apiKey = null;
        try
        {
            ApplicationInfo info = aContext.getPackageManager().getApplicationInfo(aContext.getPackageName(), PackageManager.GET_META_DATA);
            if (null != info)
            {
                metaData = info.metaData;
            }

            if (null != metaData)
            {
                apiKey = metaData.getString(aMetaKey);
            }
        }
        catch (PackageManager.NameNotFoundException e)
        {
            Log.e(TAG, "error: " + e.getMessage());
        }

        return apiKey;
    }
}

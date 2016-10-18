package com.danny.devframework.utils;

import android.content.SharedPreferences;

/**
 * Created by danny on 10/17/16.
 */

public class PrefUtils {
    private static final String TAG = "PrefUtils";
    private static PrefUtils sInstance = null;

    private static final String JSON_PUSH_NOTIFICATION = "pn";

    private SharedPreferences mPrefs;

    private PrefUtils()
    {
    }

    public static PrefUtils getInstance()
    {
        if (sInstance == null)
        {
            synchronized (PrefUtils.class)
            {
                if (sInstance == null)
                {
                    sInstance = new PrefUtils();
                }
            }
        }

        return sInstance;
    }

    public void setPrefs(SharedPreferences aPrefs)
    {
        mPrefs = aPrefs;
    }

    public SharedPreferences getPrefs()
    {
        return mPrefs;
    }

    private void setContent(String aKey, boolean aEnable)
    {
        SharedPreferences prefs = mPrefs;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(aKey, aEnable);
        editor.apply();
    }

    public boolean getContent(String aKey, boolean aDefaultValue)
    {
        SharedPreferences prefs = mPrefs;
        return prefs.getBoolean(aKey, aDefaultValue);
    }

    private void setContent(String aKey, String aContent)
    {
        SharedPreferences prefs = mPrefs;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(aKey, aContent);
        editor.apply();
    }

    public String getContent(String aKey, String aDefaultValue)
    {
        SharedPreferences prefs = mPrefs;
        return prefs.getString(aKey, aDefaultValue);
    }

    public void setPushNotification(boolean aEnable)
    {
        setContent(JSON_PUSH_NOTIFICATION, aEnable);
    }

    public boolean pushNotification()
    {
        return getContent(JSON_PUSH_NOTIFICATION, false);
    }

}

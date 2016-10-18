package com.danny.devframework;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;

import com.danny.devframework.utils.PrefUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by danny on 10/17/16.
 */

public class App extends Application {
    private static final String TAG = "App";

    private static App sApp;

    private static final Handler sUIHandler = new Handler(Looper.getMainLooper());
    private static final ExecutorService sTaskExecutor = Executors.newFixedThreadPool(5);
    private static final ExecutorService sSingleExecutor = Executors.newSingleThreadExecutor();

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        initPrefUtils();

        Log.d(TAG, "onCreate");
    }

    private void initPrefUtils()
    {
        Log.d(TAG, "initPrefUtils");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        PrefUtils.getInstance().setPrefs(prefs);
    }

    public static App currentApp()
    {
        return sApp;
    }

    public static Context getContext()
    {
        Context context = sApp.getApplicationContext();
        if (context == null)
        {
            Log.w(TAG, "the context is null");
        }

        return context;
    }

    public static boolean execute(Runnable aRunnable)
    {
        boolean success = false;
        if (aRunnable != null)
        {
            success = sUIHandler.post(aRunnable);

            if (!success)
            {
                Log.w(TAG, "the Runnable was failure placed in to the message queue");
            }
        }

        return success;
    }

    public static boolean execute(Runnable aRunnable, long aDelayMillis)
    {
        boolean success = false;
        if (aRunnable != null)
        {
            success = sUIHandler.postDelayed(aRunnable, aDelayMillis);

            if (!success)
            {
                Log.w(TAG, "the Runnable was failure placed in to the message queue");
            }
        }

        return success;
    }

    public static boolean sendMessage(Message aMessage)
    {
        boolean success = false;
        if (aMessage != null)
        {
            success = sUIHandler.sendMessage(aMessage);

            if (!success)
            {
                Log.w(TAG, "the Runnable was failure placed in to the message queue");
            }
        }

        return success;
    }

    public static ExecutorService taskExecutor()
    {
        return sTaskExecutor;
    }

    public static ExecutorService singleExecutor()
    {
        return sSingleExecutor;
    }
}

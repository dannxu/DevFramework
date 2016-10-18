package com.danny.devframework.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * Created by danny on 10/14/16.
 */

abstract class ThreadUtils {
    private static final String TAG = "ThreadUtils";

    private LooperThread    mThread;

    ThreadUtils()
    {
        mThread = new LooperThread(this);
        mThread.start();
    }

    private static class LooperHandler extends Handler
    {
        private ThreadUtils mUtils;
        LooperHandler(ThreadUtils aUtils)
        {
            mUtils = aUtils;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "threadId: " + Thread.currentThread().getId());
            if (mUtils != null)
            {
                mUtils.execute(msg);
            }
        }
    }

    protected abstract void execute(Message aMessage);

    private class LooperThread extends Thread
    {
        private ThreadUtils     mUtils;
        private LooperHandler   mHandler;

        LooperThread(ThreadUtils aUtils)
        {
            mUtils = aUtils;
        }

        @Override
        public void run() {

            Looper.prepare();

            mHandler = new LooperHandler(mUtils);

            Looper.loop();
        }

        private void post(Runnable aRunnable)
        {
            if (mHandler != null)
            {
                mHandler.post(aRunnable);
            }
        }

        private void sendMessage(Message aMessage)
        {
            if (mHandler != null)
            {
                mHandler.sendMessage(aMessage);
            }
        }

        private void sendMessage(Message aMessage, long aDelay)
        {
            if (mHandler != null)
            {
                mHandler.sendMessageDelayed(aMessage, aDelay);
            }
        }
    }

    public void post(Runnable aRunnable)
    {
        if (aRunnable != null && mThread != null)
        {
            mThread.post(aRunnable);
        }
    }

    public void sendMessage(Message aMessage)
    {
        if (aMessage != null && mThread != null)
        {
            mThread.sendMessage(aMessage);
        }
    }

    public void sendMessage(Message aMessage, long aDelay)
    {
        if (aMessage != null)
        {
            mThread.sendMessage(aMessage, aDelay);
        }
    }
}

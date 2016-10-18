package com.danny.devframework.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.danny.devframework.ui.activities.FragmentCallbacks;

/**
 * Created by danny on 10/17/16.
 */

public class BaseFragment extends Fragment {

    protected final static String TAG = "BaseFragment";

    protected FragmentCallbacks mCallbacks;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallbacks)
        {
            mCallbacks = (FragmentCallbacks)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    public String getFragmentId()
    {
        return this.getClass().getName();
    }

    public void onDisplay()
    {
        Log.d(TAG, "onDisplay");
    }

    public void onDismiss()
    {
        Log.d(TAG, "onDisplay");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause");

        super.onPause();
    }
}

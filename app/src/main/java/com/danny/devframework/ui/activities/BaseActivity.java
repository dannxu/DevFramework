package com.danny.devframework.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.danny.devframework.R;
import com.danny.devframework.ui.fragments.BaseFragment;


/**
 * Created by danny on 10/17/16.
 */

public abstract class BaseActivity extends FragmentActivity implements FragmentCallbacks {

    protected static final String TAG = "BaseActivity";

    @Override
    public void add(BaseFragment aFragment, int aId) {
        if (aFragment != null)
        {
            String tag = aFragment.getFragmentId();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, aFragment, tag);
            ft.addToBackStack(tag);
            ft.commit();
        }
    }

    @Override
    public void remove(BaseFragment aFragment) {
        if (aFragment != null)
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(aFragment);
            ft.commit();
        }
    }

    @Override
    public void replace(BaseFragment aFromFragment, BaseFragment aToFragment) {
        if (aFromFragment != null && aToFragment != null)
        {
            String tag = aFromFragment.getFragmentId();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, aToFragment, tag);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    @Override
    public void back() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
        {
            fm.popBackStack();
        }
    }

    @Override
    public void back(String aToTag, int aFlag)
    {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
        {
            fm.popBackStack(aToTag, aFlag);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResourceId());

        if (useDefault())
        {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);
            if (fragment == null)
            {
                fragment = createFragment();
                if (fragment != null)
                {
                    BaseFragment baseFragment = (BaseFragment)fragment;
                    String tag = baseFragment.getFragmentId();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fragment_container, fragment);
                    ft.addToBackStack(tag);
                    ft.commit();
                }
            }
        }
    }

    protected boolean useDefault()
    {
        return true;
    }

    protected int getLayoutResourceId()
    {
        return R.layout.activity_fragment;
    }

    protected abstract BaseFragment createFragment();

    @Override
    protected void onResume() {
        super.onResume();

        registerBroadcasts();
    }

    @Override
    protected void onPause() {
        unregisterBroadcasts();

        super.onPause();
    }

    protected void registerBroadcasts()
    {
        Log.d(TAG, "registerBroadcasts");
    }

    protected void unregisterBroadcasts()
    {
        Log.d(TAG, "unregisterBroadcasts");
    }
}
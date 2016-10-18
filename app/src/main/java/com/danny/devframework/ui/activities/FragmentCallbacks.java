package com.danny.devframework.ui.activities;

import com.danny.devframework.ui.fragments.BaseFragment;

/**
 * Created by danny on 10/17/16.
 */

public interface FragmentCallbacks {
    void add(BaseFragment aFragment, int aId);
    void remove(BaseFragment aFragment);
    void replace(BaseFragment aFromFragment, BaseFragment aToFragment);
    void back();
    void back(String aToTag, int aFlag);
}

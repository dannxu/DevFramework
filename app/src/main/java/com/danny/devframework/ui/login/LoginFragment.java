package com.danny.devframework.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danny.devframework.R;
import com.danny.devframework.ui.fragments.BaseFragment;

/**
 * Created by danny on 10/18/16.
 */

public class LoginFragment extends BaseFragment {
    private static final String TAG = "LoginFragment";

    public static LoginFragment createFragment()
    {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        return root;
    }
}

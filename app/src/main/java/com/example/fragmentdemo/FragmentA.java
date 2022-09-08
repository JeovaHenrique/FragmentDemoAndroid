package com.example.fragmentdemo;



import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;


public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container,false);
        Log.i(TAG, "onCreateView()");

        return view;
    }
}

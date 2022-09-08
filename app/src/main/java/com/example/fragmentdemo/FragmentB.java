package com.example.fragmentdemo;



import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;


public class FragmentB extends Fragment {

    private static final String TAG = FragmentB.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        Log.i(TAG, "onCreateView()");

        return view;
    }
}

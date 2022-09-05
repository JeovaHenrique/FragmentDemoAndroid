package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();

    }

    public void addFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentA, "fragA");
        transaction.commit();

    }

    public void remoFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void addFragmentB(View view) {


        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentB, "fragB");
        transaction.commit();
    }

    public void remoFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }
}
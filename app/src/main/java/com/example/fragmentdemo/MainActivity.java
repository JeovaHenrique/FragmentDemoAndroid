package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        manager.addOnBackStackChangedListener(this);

    }

    public void addFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentA, "fragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();

    }

    public void remoFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void addFragmentB(View view) {


        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,fragmentB, "fragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void remoFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("ReByFragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB,"fragB");
        transaction.addToBackStack("ReByFragB");
        transaction.commit();
    }

    public void atachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("AtachFragA");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("DetachFragA");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void showFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if(fragmentA != null) {
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {

            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        }
        else Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
    }

    public void dummyBackButtonClick(View view) {
        manager.popBackStack();
    }

    public void pop_addFragA_Inclusive_Transaction(View view) {

        manager.popBackStack("AddFragA",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void pop_addFragB_Transaction(View view) {

        manager.popBackStack("AddFragB",0);
    }

    @Override
    public void onBackStackChanged() {

        int length = manager.getBackStackEntryCount();

        StringBuilder msg = new StringBuilder("");

        for(int i = length - 1; i >=0; i--) {
            msg.append("Index ").append(i).append(" : ");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append(" \n");
        }
    }

    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        }
        else super.onBackPressed();
    }
}
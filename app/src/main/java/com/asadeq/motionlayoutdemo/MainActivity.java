package com.asadeq.motionlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayPlayerFragment(getSupportFragmentManager());
    }


    public void displayPlayerFragment(FragmentManager supportFragmentManager) {
        PlayerFragment playerFragment = new PlayerFragment();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, playerFragment, PlayerFragment.class.getSimpleName());
        fragmentTransaction.commitNowAllowingStateLoss();
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.show(playerFragment);
    }
}

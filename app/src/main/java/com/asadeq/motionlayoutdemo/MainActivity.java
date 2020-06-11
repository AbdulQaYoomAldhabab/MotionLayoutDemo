package com.asadeq.motionlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView testView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testView = findViewById(R.id.testView);
        testView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this, "Test Btn Touch", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        testView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Test Btn Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
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

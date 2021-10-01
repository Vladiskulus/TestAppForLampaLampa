package com.testingappforlampalampa.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.testingappforlampalampa.databinding.ActivityMainBinding;
import com.testingappforlampalampa.view.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        binding.vp.setAdapter(pagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.vp);
    }
}
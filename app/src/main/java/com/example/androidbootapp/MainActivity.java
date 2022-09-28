package com.example.androidbootapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.anibucket_foreground);
        setTitle("AniBucket 매장 찾기");
        if (getIntent().getStringExtra("login") == null) {
            getIntent().putExtra("login", "0");
        }

    }




    }


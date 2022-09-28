package com.example.androidbootapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Faq extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        getSupportActionBar().setTitle("AniBucket 매장 찾기");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout loMain, lo1, lo2, lo3, lo4, lo5, lo6, lo7, lo8;
        Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8 ;
        TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

        loMain = (LinearLayout) findViewById(R.id.loMain);
        lo1 = (LinearLayout) findViewById(R.id.lo1);
        lo2 = (LinearLayout) findViewById(R.id.lo2);
        lo3 = (LinearLayout) findViewById(R.id.lo3);
        lo4 = (LinearLayout) findViewById(R.id.lo4);
        lo5 = (LinearLayout) findViewById(R.id.lo5);
        lo6 = (LinearLayout) findViewById(R.id.lo6);
        lo7 = (LinearLayout) findViewById(R.id.lo7);
        lo8 = (LinearLayout) findViewById(R.id.lo8);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);


        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        tv3.setVisibility(View.GONE);
        tv4.setVisibility(View.GONE);
        tv5.setVisibility(View.GONE);
        tv6.setVisibility(View.GONE);
        tv7.setVisibility(View.GONE);
        tv8.setVisibility(View.GONE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv1.getVisibility() == View.GONE){
                    tv1.setVisibility(View.VISIBLE);
                }else{
                    tv1.setVisibility(View.GONE);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv2.getVisibility() == View.GONE){
                    tv2.setVisibility(View.VISIBLE);
                }else{
                    tv2.setVisibility(View.GONE);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv3.getVisibility() == View.GONE){
                    tv3.setVisibility(View.VISIBLE);
                }else{
                    tv3.setVisibility(View.GONE);
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv4.getVisibility() == View.GONE){
                    tv4.setVisibility(View.VISIBLE);
                }else{
                    tv4.setVisibility(View.GONE);
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv5.getVisibility() == View.GONE){
                    tv5.setVisibility(View.VISIBLE);
                }else{
                    tv5.setVisibility(View.GONE);
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv6.getVisibility() == View.GONE){
                    tv6.setVisibility(View.VISIBLE);
                }else{
                    tv6.setVisibility(View.GONE);
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv7.getVisibility() == View.GONE){
                    tv7.setVisibility(View.VISIBLE);
                }else{
                    tv7.setVisibility(View.GONE);
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv8.getVisibility() == View.GONE){
                    tv8.setVisibility(View.VISIBLE);
                }else{
                    tv8.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}

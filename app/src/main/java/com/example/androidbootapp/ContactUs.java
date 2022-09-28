package com.example.androidbootapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUs extends AppCompatActivity {

    Button submitbtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        
        submitbtn = (Button) findViewById(R.id.submitbtn);
        
        getSupportActionBar().setTitle("AniBucket 매장 찾기");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "소중한 의견 감사합니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                Intent getIntent = getIntent();
                if (getIntent.getStringExtra("login").equals("1")) {
                    intent.putExtra("login", "1");
                } else {
                    intent.putExtra("login", "0");
                }

                startActivity(intent);
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

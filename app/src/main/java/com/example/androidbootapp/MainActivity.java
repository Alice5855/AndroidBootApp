package com.example.androidbootapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbootapp.retrofit.User;
import com.example.androidbootapp.retrofit.UserApi;
import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final  String TAG = getClass().getSimpleName();

    Button btnSignIn, btnGoSignUp;
    EditText signInId, signInPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInId = (EditText) findViewById(R.id.signInId);
        signInPw = (EditText) findViewById(R.id.signInPw);


        btnGoSignUp = (Button) findViewById(R.id.btnGoSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = signInId.getText().toString();
                String pw = signInPw.getText().toString();

                User loginInfo = new User();
                loginInfo.setUserId(id);
                loginInfo.setUserPassword(pw);

                Moshi moshi = new Moshi.Builder().build();

//                String json = moshi.adapter(User.class).indent("  ").toJson(loginInfo);
//                System.out.println(json);

                // Retrofit ?????? ?????? ??? MoshiConverter ??????
                Retrofit retrofit = new Retrofit.Builder()
//                      .baseUrl("http://InsertYourIP:9003/")
                        .baseUrl("http://192.168.0.111:9004/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build();

                UserApi api = retrofit.create(UserApi.class);

                Call<Boolean> call = api.postUser(loginInfo);
                call.enqueue(new Callback<Boolean>() {
                    // Controller?????? response.isSuccessful ?????? ??????(?????? ??????) ??? ????????? ???????????? ??????
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.isSuccessful()){
                            boolean userExists = response.body();

                            if (userExists) {
                                Intent intent = new Intent(getApplicationContext(), SignUpSuccess.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "????????? ?????? ??????????????? ???????????? ????????????", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Log.d(TAG,"Status Code : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.d(TAG,"Fail msg : " + t.getMessage());
                    }
                });
            }
        });
    }
}
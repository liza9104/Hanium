package com.cookandroid.hanium;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText loginNumber,loginPw;
    private Button loginBtn, joinBtn,findPasswordBtn;
    private ServiceApi service;
    public int resultCode;
    CheckBox autoLoginCheck;
    String id,pw;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("preferences",MODE_PRIVATE);


        loginNumber = findViewById(R.id.login_number);
        loginPw = findViewById(R.id.login_password);
        loginBtn = findViewById(R.id.login_button);
        joinBtn = findViewById(R.id.join_button);
        service = RetrofitClient.getClient().create(ServiceApi.class);
        autoLoginCheck = findViewById(R.id.autoLoginCheck);
        findPasswordBtn = findViewById(R.id.find_password_btn);

        loginBtn.setOnClickListener(onClickListener);

        joinBtn.setOnClickListener(onClickListener);

        findPasswordBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.login_button:
                    attemptLogin();
                    break;
                case R.id.join_button:
                    Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                    startActivity(intent);
                    break;
                case R.id.find_password_btn:
                    Intent pwIntent = new Intent(getApplicationContext(), FindPasswordPopUp.class);
                    startActivity(pwIntent);
                    break;
            }
        }
    };
    private void attemptLogin() {
        loginNumber.setError(null);
        loginPw.setError(null);

        id = loginNumber.getText().toString();
        pw = loginPw.getText().toString();

        boolean cancel = false;
        View focusView = null;



        if (cancel) {
            focusView.requestFocus();
        } else {
            startLogin(new LoginData(id, pw));
        }
    }

    private void startLogin(LoginData data) {
        service.userLogin(data).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse result = response.body();
                resultCode = result.getCode();
                id = result.getUserId();
                editor = sharedPreferences.edit();
                String nickname = result.getNickname();
                editor.putString("nickname",nickname);


                if(resultCode==200){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    editor.putString("id",id);
                    editor.commit();
                    startActivity(intent);
                    finish();
                    if(autoLoginCheck.isChecked()){
                        editor.putBoolean("auto-login-activate",true);
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("로그인 에러 발생", t.getMessage());
            }
        });
      }


}
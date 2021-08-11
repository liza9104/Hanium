package com.cookandroid.hanium;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.cookandroid.hanium.RetrofitClient.getClient;

public class initialLayout extends AppCompatActivity {
    Button schoolbtn;
    Button testBtn;
    private ServiceApi service;
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);

        service = getClient().create(ServiceApi.class);

        final String[] school = {"△△대학교", "대학교1", "대학교2"};
        Spinner spinner = findViewById(R.id.school_spinner);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, school);
        spinner.setAdapter(adapter);

        schoolbtn = findViewById(R.id.school_btn);
        schoolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        testBtn = findViewById(R.id.test_btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptTest();
            }
        });
        text = findViewById(R.id.text);
    }



    private void attemptTest() {

        String email = "test@naver.com";

        startTest(new testData(email));
    }

    private void startTest(testData data) {
        service.test(data).enqueue(new Callback<testResponse>() {
            @Override
            public void onResponse(Call<testResponse> call, Response<testResponse> response) {
                testResponse result = response.body();

                String name = "이름 : " + result.getFirstname() + result.getLastname();
                String emailString = "이메일 : " + result.getEmail();
                String pw = "비밀번호 : " + result.getPw();
                String pwc = "비밀번호 확인 : " + result.getPwc();

                String string = name + "\n" + emailString + "\n" + pw + "\n" + pwc;
                text.setText(string);
            }
            @Override
            public void onFailure(Call<testResponse> call, Throwable t) {
                Toast.makeText(initialLayout.this, "테스트 에러 발생", Toast.LENGTH_SHORT).show();
            }


        });
    }


}
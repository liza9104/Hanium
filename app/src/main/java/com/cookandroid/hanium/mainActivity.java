package com.cookandroid.hanium;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.cookandroid.hanium.RetrofitClient.getClient;

public class mainActivity extends AppCompatActivity {
    ImageView mainIcon;
    Button myPage_btn, bulletin_btn, rr_btn;
    TextView notice, today_menu, notice_cont, today_menu_cont;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainIcon = findViewById(R.id.mainIcon);
        myPage_btn = findViewById(R.id.myPage_btn);
        bulletin_btn = findViewById(R.id.bulletin_btn);
        notice = findViewById(R.id.notice);
        rr_btn = findViewById(R.id.rr_btn);
        today_menu = findViewById(R.id.todayMenu);
        notice_cont = findViewById(R.id.notice_cont);
        today_menu_cont = findViewById(R.id.todayMenu_cont);

        Intent intent1 = getIntent();
        id = intent1.getStringExtra("id");


        rr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), RR_info.class);
                intent2.putExtra("id", id);
                startActivity(intent2);
                Toast.makeText(mainActivity.this,"id : "+id, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}
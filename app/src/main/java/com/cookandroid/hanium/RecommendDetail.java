package com.cookandroid.hanium;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecommendDetail extends AppCompatActivity {
    TextView title, desc, nickname;
    TextView dom, smoke, sleepHabit, food, sleepTime, NumberOfClean, numberOfShower;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_detail);
        Intent intent = getIntent();
        title = findViewById(R.id.detailTitle);
        desc = findViewById(R.id.detailDesc);
        nickname = findViewById(R.id.detailNickname);
        dom = findViewById(R.id.detailDom);
        smoke = findViewById(R.id.detailSmoke);
        sleepHabit = findViewById(R.id.detailSleepHabit);
        food = findViewById(R.id.detailFood);
        sleepTime = findViewById(R.id.detailSleepTime);
        NumberOfClean = findViewById(R.id.detailNumberOfClean);
        numberOfShower = findViewById(R.id.detailNumberOfShower);

        title.setText(intent.getStringExtra("title"));

    }


}

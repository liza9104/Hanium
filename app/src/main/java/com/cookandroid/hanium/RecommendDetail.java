package com.cookandroid.hanium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecommendDetail extends AppCompatActivity {
    TextView title, desc, nickname;
    TextView dom, smoke, sleepHabit, food, sleepTime, numberOfClean, numberOfShower;
    Button startChatBtn;
    String partnerId, partnerNickname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_detail);


        title = findViewById(R.id.detailTitle);
        desc = findViewById(R.id.detailDesc);
        nickname = findViewById(R.id.detailNickname);
        dom = findViewById(R.id.detailDom);
        smoke = findViewById(R.id.detailSmoke);
        sleepHabit = findViewById(R.id.detailSleepHabit);
        food = findViewById(R.id.detailFood);
        sleepTime = findViewById(R.id.detailSleepTime);
        numberOfClean = findViewById(R.id.detailNumberOfClean);
        numberOfShower = findViewById(R.id.detailNumberOfShower);
        startChatBtn = findViewById(R.id.chatBtn);

        Intent intent = getIntent();
        RecommendData data = (RecommendData) intent.getSerializableExtra("data");
        title.setText(data.getTitle());
        desc.setText(data.getDesc());
        partnerId = data.getId();
        partnerNickname = data.getNickname();



        nickname.setText(data.getNickname());

        dom.setText(data.getDom());
        smoke.setText(data.getSmoke());
        sleepHabit.setText(data.getSleepHabit());
        food.setText(data.getFood());
        sleepTime.setText(data.getSleepTime());
        numberOfShower.setText(data.getNumberOfShower());
        numberOfClean.setText(data.getNumberOfCleaning());

        startChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatRoomIntent = new Intent(RecommendDetail.this, ChatRoomActivity.class);
                chatRoomIntent.putExtra("partnerId",partnerId);
                chatRoomIntent.putExtra("partnerNickname",partnerNickname);
                startActivity(chatRoomIntent);
            }
        });



    }


}

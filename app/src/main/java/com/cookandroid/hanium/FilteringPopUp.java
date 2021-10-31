package com.cookandroid.hanium;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FilteringPopUp extends Activity {
    private RadioGroup inputDom, inputSmoke, inputSleepHabit, inputFood, inputSleepTime, inputNumberOfCleaning, inputNumberOfShower;
    private CheckBox snoring, teethGrinding, sleepTalking;
    private Button apply_btn;
    private ServiceApi service;
    private String id, sex, dom, smoke, sleepHabit, food, sleepTime, numberOfCleaning, numberOfShower, title, desc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtering_popup);

        inputDom = findViewById(R.id.dom);
        inputSmoke = findViewById(R.id.smoke);
        inputSleepHabit = findViewById(R.id.inputSleepHabit);
        snoring = findViewById(R.id.snoring);
        teethGrinding = findViewById(R.id.teethGrinding);
        sleepTalking = findViewById(R.id.sleepTalking);

        inputFood = findViewById(R.id.food);
        inputSleepTime = findViewById(R.id.sleepTime);
        inputNumberOfCleaning = findViewById(R.id.NumberOfCleaning);
        inputNumberOfShower = findViewById(R.id.NumberOfShower);

        apply_btn = findViewById(R.id.applyBtn);
        service = RetrofitClient.getClient().create(ServiceApi.class);

        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRecommendSearch();
            }
        });


    }

    private void attemptRecommendSearch() {





    }
}

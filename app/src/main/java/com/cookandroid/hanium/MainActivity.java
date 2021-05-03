package com.cookandroid.hanium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cookandroid.hanium.R;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    LinearLayout info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.info);
        rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton recommendYes = findViewById(R.id.recommendyes);
                RadioButton recommendNo = findViewById(R.id.recommendno);

                if(recommendYes.isChecked()) info.setVisibility(View.VISIBLE);
                else info.setVisibility(View.GONE);
            }
        });


    }

}

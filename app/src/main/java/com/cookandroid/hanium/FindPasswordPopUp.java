package com.cookandroid.hanium;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindPasswordPopUp extends Activity {
    EditText popUpId, popUpEmail;
    Button tempPasswordIssueBtn,tempPasswordCopyBtn,popUpCloseBtn;
    String id, email, tempPassword;
    TextView tempPasswordTv;
    private ServiceApi service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.find_password_popup);
        service = RetrofitClient.getClient().create(ServiceApi.class);
        popUpId = findViewById(R.id.popUpId);
        popUpEmail = findViewById(R.id.popUpEmail);
        tempPasswordIssueBtn = findViewById(R.id.tempPasswordIssueBtn);
        tempPasswordCopyBtn = findViewById(R.id.tempPasswordCopyBtn);
        tempPasswordTv=findViewById(R.id.tempPasswordTv);
        popUpCloseBtn = findViewById(R.id.popUpCloseBtn);

        tempPasswordIssueBtn.setOnClickListener(onClickListener);
        tempPasswordCopyBtn.setOnClickListener(onClickListener);
        popUpCloseBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tempPasswordIssueBtn:
                    attemptIssueTempPassword();
                    break;
                case R.id.tempPasswordCopyBtn:
                    copyTempPassword();
                    break;
                case R.id.popUpCloseBtn:
                    finish();

            }
        }
    };

    private void copyTempPassword() {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        String text =tempPasswordTv.getText().toString();
        ClipData clip = ClipData.newPlainText("tempPassword",text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(FindPasswordPopUp.this, "클립보드에 복사했습니다.", Toast.LENGTH_SHORT).show();
    }


    private void attemptIssueTempPassword() {
        boolean cancel = false;
        View focusView = null;

        id = popUpId.getText().toString();
        email = popUpEmail.getText().toString();

        if (id.isEmpty()) {
            popUpId.setError("사번을 입력해주세요.");
            focusView = popUpId;
            cancel = true;
        }

        if (email.isEmpty()) {
            popUpEmail.setError("이메일을 입력해주세요.");
            focusView = popUpEmail;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startIssueTempPassword(new TempPasswordData(id,email));
        }
    }

    private void startIssueTempPassword(TempPasswordData data) {
        service.issueTempPassword(data).enqueue(new Callback<TempPasswordResponse>() {
            @Override
            public void onResponse(Call<TempPasswordResponse> call, Response<TempPasswordResponse> response) {
                TempPasswordResponse result = response.body();
                int resultCode = result.getCode();
                String message = result.getMessage();

                if(resultCode ==204){
                    Toast.makeText(FindPasswordPopUp.this, message, Toast.LENGTH_SHORT).show();
                }
                if(resultCode ==200){
                    tempPassword=result.getPw();
                    tempPasswordTv.setText(tempPassword);
                    Toast.makeText(FindPasswordPopUp.this, message, Toast.LENGTH_SHORT).show();
                }

            }



            @Override
            public void onFailure(Call<TempPasswordResponse> call, Throwable t) {
                Toast.makeText(FindPasswordPopUp.this, "임시비밀번호 발급 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("임시 비밀번호 발급 에러 발생", t.getMessage());

            }
        });
    }
}

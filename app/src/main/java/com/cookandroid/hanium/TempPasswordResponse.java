package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class TempPasswordResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("pw")
    private String pw;

    @SerializedName("pwChk")
    private String pwChk;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getPw() {
        return pw;
    }

    public String getPwChk() {
        return pwChk;
    }
}


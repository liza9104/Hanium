package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

public class testResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("email")
    private String email;

    @SerializedName("pw")
    private String pw;

    @SerializedName("pwc")
    private String pwc;

    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname; }

    public String getEmail() { return email; }

    public String getPw() { return pw; }

    public String getPwc() { return pwc; }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}



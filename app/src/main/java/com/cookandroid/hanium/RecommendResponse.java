package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class RecommendResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ArrayList<RecommendData> data;


    @SerializedName("inputCheck")
    private boolean inputCheck;


    public RecommendResponse(String code, String message, ArrayList<RecommendData> data, boolean inputCheck) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.inputCheck = inputCheck;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<RecommendData> getData() {
        return data;
    }

    public void setData(ArrayList<RecommendData> data) {
        this.data = data;
    }

    public boolean isInputCheck() {
        return inputCheck;
    }

    public void setInputCheck(boolean inputCheck) {
        this.inputCheck = inputCheck;
    }
}

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

    public RecommendResponse(String code, String message, ArrayList<RecommendData> data) {
        this.code = code;
        this.message = message;
        this.data = data;
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
}

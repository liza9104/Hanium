package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class RR_response {
    @SerializedName("sex")
    private String sex;

    @SerializedName("dom")
    private int dom;

    @SerializedName("smoke")
    private int smoke;

    @SerializedName("sleep_habit")
    private int sleep_habit;

    @SerializedName("food")
    private int food;

    @SerializedName("sleepTime")
    private int sleepTime;

    @SerializedName("numberOfCleaning")
    private int numberOfCleaning;

    @SerializedName("NumberOfShower")
    private int NumberOfShower;

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }




}

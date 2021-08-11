package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class RRData {
    @SerializedName("id")
    private String id;

    @SerializedName("sex")
    private String sex;

    @SerializedName("dom")
    private String dom;

    @SerializedName("smoke")
    private String smoke;

    @SerializedName("sleepHabit")
    private String sleepHabit;

    @SerializedName("food")
    private String food;

    @SerializedName("sleepTime")
    private String sleepTime;

    @SerializedName("numberOfCleaning")
    private String numberOfCleaning;

    @SerializedName("numberOfShower")
    private String numberOfShower;

    @SerializedName("code")
    private int code;

    public RRData(String id, String sex, String dom, String smoke, String sleepHabit,
                  String food, String sleepTime, String numberOfCleaning, String numberOfShower) {
        this.id = id;
        this.sex = sex;
        this.dom = dom;
        this.smoke = smoke;
        this.sleepHabit = sleepHabit;
        this.food = food;
        this.sleepTime = sleepTime;
        this.numberOfCleaning = numberOfCleaning;
        this.numberOfShower = numberOfShower;

    }

    public int getCode() {
        return code;
    }


}
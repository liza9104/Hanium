package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class RecommendData {
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

    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String desc;

    @SerializedName("code")
    private int code;

    public RecommendData(String id, String sex, String dom, String smoke, String sleepHabit,
                         String food, String sleepTime, String numberOfCleaning, String numberOfShower, String title, String desc) {
        this.id = id;
        this.sex = sex;
        this.dom = dom;
        this.smoke = smoke;
        this.sleepHabit = sleepHabit;
        this.food = food;
        this.sleepTime = sleepTime;
        this.numberOfCleaning = numberOfCleaning;
        this.numberOfShower = numberOfShower;
        this.title = title;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getSleepHabit() {
        return sleepHabit;
    }

    public void setSleepHabit(String sleepHabit) {
        this.sleepHabit = sleepHabit;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getNumberOfCleaning() {
        return numberOfCleaning;
    }

    public void setNumberOfCleaning(String numberOfCleaning) {
        this.numberOfCleaning = numberOfCleaning;
    }

    public String getNumberOfShower() {
        return numberOfShower;
    }

    public void setNumberOfShower(String numberOfShower) {
        this.numberOfShower = numberOfShower;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
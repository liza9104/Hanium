package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class testData {
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


    public testData(String email) {
        this.email = email;
    }

}

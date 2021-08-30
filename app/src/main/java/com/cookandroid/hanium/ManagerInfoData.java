package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;


class ManagerInfoData {
    @SerializedName("firstname")
    String firstname;

    @SerializedName("lastname")
    String lastname;

    @SerializedName("email")
    String email;

    @SerializedName("pw")
    String pw;

    @SerializedName("pwc")
    String pwc;


    public ManagerInfoData(String firstname, String lastname, String email, String pw, String pwc) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.pw = pw;
        this.pwc = pwc;
    }
}

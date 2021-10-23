package com.cookandroid.hanium;

import com.google.gson.annotations.SerializedName;

class TempPasswordData {
    @SerializedName("id")
    private String id;

    @SerializedName("email")
    private String email;

    public TempPasswordData(String id, String email){
        this.id = id;
        this.email =email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

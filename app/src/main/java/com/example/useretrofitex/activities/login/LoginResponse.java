package com.example.useretrofitex.activities.login;

import com.google.gson.annotations.SerializedName;

class LoginResponse {


    private String my_id;
    private String password;

    @SerializedName("body")
    private String body;

    @SerializedName("msg")
    private String msg;

    public String getMy_id() {
        return my_id;
    }

    public String getPassword() {
        return password;
    }

    public String getBody() {
        return body;
    }
    public String getMsg() {
        return msg;
    }

}

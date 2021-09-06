package com.example.useretrofitex.addr.model;

import com.google.gson.annotations.SerializedName;

public class AddressResponse {
    private String address;
    @SerializedName("body")
    private String text;
    private int number;

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }

    public String getNumber() {
        String mNumber = Integer.toString(number);
        return mNumber;
    }
}

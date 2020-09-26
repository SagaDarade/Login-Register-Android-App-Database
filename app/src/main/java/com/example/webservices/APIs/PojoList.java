package com.example.webservices.APIs;

import com.google.gson.annotations.SerializedName;

public class PojoList {
    @SerializedName("pid")
    private int id;

    @SerializedName("pname")
    private String pName;

    @SerializedName("duration")
    private String pDuration;

    @SerializedName("submit")
    private String submit;

    public PojoList(int id, String pName, String pDuration, String submit) {
        this.id = id;
        this.pName = pName;
        this.pDuration = pDuration;
        this.submit = submit;
    }

    public int getId() {
        return id;
    }

    public String getpName() {
        return pName;
    }

    public String getpDuration() {
        return pDuration;
    }

    public String getSubmit() {
        return submit;
    }
}

package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GsonCompatibleDate {

    // instance vars
    @SerializedName("$date")
    private Long date;

    // constructors
    public GsonCompatibleDate(Long date) {
        this.date = date;
    }

    // getters and setters
    public Date getDate() {
        return new Date(date);
    }

    public void setDate(Date date) {
        this.date = date.getTime();
    }
}


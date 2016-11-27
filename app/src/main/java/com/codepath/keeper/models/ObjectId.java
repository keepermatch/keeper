package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ObjectId implements Serializable {

    // instance vars
    @SerializedName("$oid")
    private String id;

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

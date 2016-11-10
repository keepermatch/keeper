package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Vouch {

    @SerializedName("_id")
    public Id id;
    public MongoDate created;
    public Id voucher;
    public Id vouchee;
    public List<SubVouch> vouches = new ArrayList<SubVouch>();
    public String photo;
    public String voucherName;
    public List<Id> likes = new ArrayList<Id>();

}



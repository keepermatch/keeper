package com.codepath.keeper.models;

/**
 * Created by matthewlent on 11/10/16.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SubVouch {

    @SerializedName("_id")
    public Id id;
    public MongoDate created;
    public String title;
    public String body;
    public List<Id> likes = new ArrayList<Id>();
    public String cancelToken;
    public boolean isCancelled;
    public boolean isConfirmed;
}

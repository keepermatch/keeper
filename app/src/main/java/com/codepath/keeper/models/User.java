
package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("vouches_received")
    public List<Vouch> vouchesReceived = new ArrayList<Vouch>();
    public String gender;
    public String birthday;
    public List<String> ethnicity = new ArrayList<String>();
    @SerializedName("profile_picture")
    public String profilePicture;
    public List<String> religion = new ArrayList<String>();
    @SerializedName("picture_urls")
    public List<String> pictureUrls = new ArrayList<String>();
    public String zipcode;
    @SerializedName("first_name")
    public String firstName;
    public List<String> education = new ArrayList<String>();
    public String occupation;
    @SerializedName("_id")
    public Id id;
    public String height;

}

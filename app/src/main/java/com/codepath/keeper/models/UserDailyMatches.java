
package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class UserDailyMatches {

    @SerializedName("fetched_date")
    public String fetchedDate;
    public List<User> users = new ArrayList<User>();
    @SerializedName("should_vouch")
    public boolean shouldVouch;

}


package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class UserDailyMatchesResponse {

    // instance vars
    @SerializedName("fetched_date")
    private String fetchedDate;
    private List<User> users = new ArrayList<User>();
    @SerializedName("should_vouch")
    private boolean shouldVouch;

    // getters and setters
    public Date getFetchedDate() {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date fetchedDate = null;
        try {
            fetchedDate = df.parse(this.fetchedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fetchedDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isShouldVouch() {
        return shouldVouch;
    }

    public void setShouldVouch(boolean shouldVouch) {
        this.shouldVouch = shouldVouch;
    }
    
}


package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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
    public String getFetchedDate() {
        return fetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        this.fetchedDate = fetchedDate;
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

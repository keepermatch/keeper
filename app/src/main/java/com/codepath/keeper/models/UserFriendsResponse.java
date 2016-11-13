package com.codepath.keeper.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelsova on 11/13/16.
 */

public class UserFriendsResponse {

    // instance vars
    private List<User> friends;

    // constructors
    public UserFriendsResponse() {
        friends = new ArrayList<User>();
    }

    // getters and setters
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}

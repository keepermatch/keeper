package com.codepath.keeper.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelsova on 11/20/16.
 */

public class MatchMakersResponse {

    // instance vars
    private List<User> friends;

    // constructors
    public MatchMakersResponse() {
        friends = new ArrayList<User>();
    }

    // getters and setters
    public List<User> getMatchMakers() {
        return friends;
    }

}

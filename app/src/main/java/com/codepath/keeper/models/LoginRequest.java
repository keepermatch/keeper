package com.codepath.keeper.models;

/**
 * Created by matthewlent on 11/15/16.
 */

public class LoginRequest {

    private String accessToken;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

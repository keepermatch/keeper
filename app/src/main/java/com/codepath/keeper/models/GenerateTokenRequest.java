package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matthewlent on 1/1/17.
 */

public class GenerateTokenRequest {

    @SerializedName("app_id")
    private String appId;

    @SerializedName("user_id")
    private String userId;

    private String nonce;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}

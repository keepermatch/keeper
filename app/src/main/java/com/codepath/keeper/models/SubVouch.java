package com.codepath.keeper.models;

/**
 * Created by matthewlent on 11/10/16.
 */

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SubVouch implements Serializable {

    // instance vars
    @SerializedName("_id")
    private ObjectId objectId;
    private GsonCompatibleDate created;
    private String title;
    private String body;
    private List<ObjectId> likes = new ArrayList<ObjectId>();
    @SerializedName("cancel_token")
    private String cancelToken;
    @SerializedName("is_cancelled")
    private boolean isCancelled;
    @SerializedName("is_confirmed")
    private boolean isConfirmed;

    public Vouch getParentVouch() {
        return parentVouch;
    }

    public void setParentVouch(Vouch parentVouch) {
        this.parentVouch = parentVouch;
    }

    private Vouch parentVouch;

    // getters and setters
    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public GsonCompatibleDate getCreated() {
        return created;
    }

    public void setCreated(GsonCompatibleDate created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<ObjectId> getLikes() {
        return likes;
    }

    public void setLikes(List<ObjectId> likes) {
        this.likes = likes;
    }

    public String getCancelToken() {
        return cancelToken;
    }

    public void setCancelToken(String cancelToken) {
        this.cancelToken = cancelToken;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }


}

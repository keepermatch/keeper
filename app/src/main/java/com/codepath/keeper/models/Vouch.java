package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Vouch {

    // instance vars
    @SerializedName("_id")
    private ObjectId objectId;
    private GsonCompatibleDate created;
    private ObjectId voucher;
    private ObjectId vouchee;
    @SerializedName("vouches")
    public List<SubVouch> subVouches = new ArrayList<SubVouch>();
    @SerializedName("photo")
    private String photoUrl;
    @SerializedName("voucher_name")
    private String voucherName;
    private List<ObjectId> likes = new ArrayList<ObjectId>();

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

    public ObjectId getVoucher() {
        return voucher;
    }

    public void setVoucher(ObjectId voucher) {
        this.voucher = voucher;
    }

    public ObjectId getVouchee() {
        return vouchee;
    }

    public void setVouchee(ObjectId vouchee) {
        this.vouchee = vouchee;
    }

    public List<SubVouch> getSubVouches() {
        return subVouches;
    }

    public void setSubVouches(List<SubVouch> subVouches) {
        this.subVouches = subVouches;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public List<ObjectId> getLikes() {
        return likes;
    }

    public void setLikes(List<ObjectId> likes) {
        this.likes = likes;
    }

}



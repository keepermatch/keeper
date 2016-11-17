package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by matthewlent on 11/15/16.
 */

public class UpdateUserRequest {

    private String id;
    @SerializedName("token_id")
    private String tokenId;
    @SerializedName("is_single")
    private boolean isSingle;
    @SerializedName("li_invite")
    private String liInvite;
    @SerializedName("interested_in")
    private String interestedIn;
    private String zipcode;
    @SerializedName("picture_urls")
    private List<String> pictureUrls;
    @SerializedName("profile_picture")
    private String profilePicture;
    @SerializedName("small_profile_picture")
    private String smallProfilePicture;
    private String education;
    private String occupation;
    private String height;
    private List<String> religion;
    private List<String> ethnicity;
    private String neighbourhood;
    @SerializedName("finished_signup")
    private boolean finishedSignup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public String getLiInvite() {
        return liInvite;
    }

    public void setLiInvite(String liInvite) {
        this.liInvite = liInvite;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getSmallProfilePicture() {
        return smallProfilePicture;
    }

    public void setSmallProfilePicture(String smallProfilePicture) {
        this.smallProfilePicture = smallProfilePicture;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<String> getReligion() {
        return religion;
    }

    public void setReligion(List<String> religion) {
        this.religion = religion;
    }

    public List<String> getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(List<String> ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public boolean isFinishedSignup() {
        return finishedSignup;
    }

    public void setFinishedSignup(boolean finishedSignup) {
        this.finishedSignup = finishedSignup;
    }

}

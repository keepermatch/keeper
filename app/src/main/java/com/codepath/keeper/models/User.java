
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
public class User {

    // instance vars
    @SerializedName("vouches_received")
    private List<Vouch> vouchesReceived = new ArrayList<Vouch>();
    private String gender;
    private String birthday;
    private List<String> ethnicity = new ArrayList<String>();
    @SerializedName("profile_picture")
    private String profilePicture;
    private List<String> religion = new ArrayList<String>();
    @SerializedName("picture_urls")
    private List<String> pictureUrls = new ArrayList<String>();
    private String zipcode;
    @SerializedName("first_name")
    private String firstName;
    private List<String> education = new ArrayList<String>();
    private String occupation;
    @SerializedName("_id")
    private ObjectId objectId;
    private String height;

    // getters and setters
    public List<Vouch> getVouchesReceived() {
        return vouchesReceived;
    }

    public void setVouchesReceived(List<Vouch> vouchesReceived) {
        this.vouchesReceived = vouchesReceived;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        Date birthday = null;
        try {
            birthday = df.parse(this.birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthday;
    }

    public List<String> getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(List<String> ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<String> getReligion() {
        return religion;
    }

    public void setReligion(List<String> religion) {
        this.religion = religion;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}

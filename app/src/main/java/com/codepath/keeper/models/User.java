
package com.codepath.keeper.models;

import com.google.gson.annotations.SerializedName;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User implements Serializable {

    public static final String AGNOSTIC = "agnostic";
    public static final String MATCHMAKER_USER_KEY = "matchmaker_user"; // key when in a bundle
    public static final String MATCHMAKEE_USER_KEY = "matchmakee_user"; // key when in a bundle
    public static final String CURRENT_USER = "current_user"; // key when in a bundle

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
    @SerializedName("is_single")
    private boolean isSingle;

    // getters and setters

    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }
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

    private Date getBirthdayFromString(String birthday, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        try {
            return df.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getBirthdayAsDate() {
        String format1 = "MM/dd/yyyy";
        Date date1 = getBirthdayFromString(this.birthday, format1);
        if (date1 != null) return date1;

        String format2 = "yyyy-MM-dd";
        Date date2 = getBirthdayFromString(this.birthday, format2);
        if (date2 != null) return date2;

        return new Date();
    }

    public int getAge() {
        Years years = Years.yearsBetween(new LocalDate(getBirthdayAsDate()), new LocalDate());
        return years.getYears();
    }

    public List<String> getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(List<String> ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getProfilePicture() {
        return profilePicture.replace("http://graph", "https://graph");
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
        for (final ListIterator<String> i = pictureUrls.listIterator(); i.hasNext();) {
            final String element = i.next();
            i.set(element.replace("http://graph", "https://graph"));
        }
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

    //TODO: put in backend or put in file db a hashmap of zipcode to location
    public String getLocation() {
        return "SOMA";
    }

    public static String getHeightInFeetAndInches(int inches) {
        int feet = inches / 12;
        int leftover = inches % 12;
        return(feet + "'-" + leftover + "\"");
    }

}

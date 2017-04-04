package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chao on 2017/3/23.
 */
public class Record {
    private String lastName;
    private String firstName;
    private Gender gender;
    private String favoriteColor;
    private Date dateOfBirth;
    private DateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");
    public Record() {}
    public Record(String lastName, String firstName, Gender gender, String favoriteColor, Date dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String toString() {
        return lastName + " | " + firstName + " | " + gender + " | " + favoriteColor + " | "
                + dateFormat.format(dateOfBirth);
    }
}
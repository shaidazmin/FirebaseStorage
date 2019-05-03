package com.example.firebasestorage;

public class UserDetails {

    String userName;
    String userEmail;
    String userCollage;
    String userNumber;

    public UserDetails(String userName, String userEmail, String userCollage, String userNumber) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userCollage = userCollage;
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCollage() {
        return userCollage;
    }

    public void setUserCollage(String userCollage) {
        this.userCollage = userCollage;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}

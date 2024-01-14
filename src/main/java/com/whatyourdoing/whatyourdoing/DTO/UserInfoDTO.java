package com.whatyourdoing.whatyourdoing.DTO;

import java.util.Objects;

public class UserInfoDTO {
    private String fname;
    private String lname;
    private String email;
    private String userID;
    private String password;

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoDTO that = (UserInfoDTO) o;
        return Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(email, that.email) && Objects.equals(userID, that.userID) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, email, userID, password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}

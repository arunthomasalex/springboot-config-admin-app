package com.run.clientapp.domain;

import java.util.Date;

public class UserInfo {

    private String firstname;
	private String lastname;
	private String email;
	private String gender;
	private Date dob;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserInfo [dob=" + dob + ", email=" + email + ", firstname=" + firstname + ", gender=" + gender
                + ", lastname=" + lastname + "]";
    }
}
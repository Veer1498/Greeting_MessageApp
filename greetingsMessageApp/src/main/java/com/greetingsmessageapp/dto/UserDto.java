package com.greetingsmessageapp.dto;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
public class UserDto {
    public String firstname;
    public String lastname;

    public UserDto(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

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

}

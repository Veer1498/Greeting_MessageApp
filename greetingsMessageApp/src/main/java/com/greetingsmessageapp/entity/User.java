package com.greetingsmessageapp.entity;

import com.greetingsmessageapp.dto.UserDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;

    public User() {
    }

    public User(UserDto userdto) {
        this.firstname = userdto.firstname;
        this.lastname = userdto.lastname;
    }

    public void updateUser(UserDto userdto) {
        this.firstname = userdto.firstname;
        this.lastname = userdto.lastname;
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

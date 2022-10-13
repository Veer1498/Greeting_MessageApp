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
public class Greeting {
    @Id
    @GeneratedValue
    private long id;
    private String greeting;

    public Greeting() {

    }

    public Greeting(UserDto userdta) {
        this.greeting = "Hello " + userdta.firstname + " " + userdta.lastname;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting(long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }
}

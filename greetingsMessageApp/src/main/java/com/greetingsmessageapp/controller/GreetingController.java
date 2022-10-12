package com.greetingsmessageapp.controller;

import com.greetingsmessageapp.entity.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello ";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public String greetings(){
        return "Hello World";
    }



    @GetMapping("/{name}")
    public String greetings(@PathVariable String name) {
        return template + name;
    }

    @PostMapping(value = { "fullName" })
    public String greeting(@RequestParam(value = "firstName") String firstName,@RequestParam(value = "lastName") String lastName) {
        if (firstName =="" && lastName == ""){
            return "Hello Bridgelabz";
        }
        else if (firstName !="" && lastName == "") {
            return template +" "+ firstName+ ", Welcome to My Program";
        }
        else if (firstName =="" && lastName != "") {
            return template +" "+ lastName+ ", Welcome to My Program";
        }
        return template +" "+ firstName +" "+ lastName+", Welcome to My Program";
    }
}

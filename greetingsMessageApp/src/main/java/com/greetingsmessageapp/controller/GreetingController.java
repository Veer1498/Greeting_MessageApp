package com.greetingsmessageapp.controller;

import com.greetingsmessageapp.entity.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();



    @GetMapping(value = { "", "/", "/home" })
    public Model greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Model(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/{name}")
    public Model greetings(@PathVariable String name) {
        return new Model(counter.incrementAndGet(), String.format(template, name));
    }
}

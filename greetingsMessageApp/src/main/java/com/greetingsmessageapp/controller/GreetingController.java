package com.greetingsmessageapp.controller;

import com.greetingsmessageapp.Repo.GreetingRepo;
import com.greetingsmessageapp.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    public GreetingRepo repo;

    private static final String template = "Hello ";
    private final AtomicLong counter = new AtomicLong();

    //UC-1
    @GetMapping("/hello")
    public String greetings(){
        return "Hello World";
    }


    //UC -2
    @GetMapping("/{name}")
    public String greetings(@PathVariable String name) {
        return template + name;
    }


    //UC-3
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

    //UC-4
    @PostMapping(value = { "saving" })
    public Model addUser(@RequestBody Model greeting) {
       Model model = new Model(counter.incrementAndGet(), greeting.getFirstName(),greeting.getLastName());
        return repo.save(model);
    }

    //UC-5
    /*
    (Find by ID) is an Inbuilt Method for finding particular data with id.
     */

    @GetMapping(value ={"/getByID/{idn}"})
    public Optional<Model> getUserByID(@PathVariable int idn){
        return repo.findById(idn);
    }

    //UC-6
    //List All

    @GetMapping(value ={"/listAll"})
    public List<Model> getAll(){
        return repo.findAll();
    }

    //UC-8
    //Delete Method

    @DeleteMapping(value = {"/delete"})
    public void deleteByID(@PathVariable int idno){
        repo.deleteById(idno);
    }

}

package com.greetingsmessageapp.controller;

import com.greetingsmessageapp.Repo.UserRepo;
import com.greetingsmessageapp.dto.UserDto;
import com.greetingsmessageapp.entity.Greeting;
import com.greetingsmessageapp.entity.User;

import com.greetingsmessageapp.service.GreetService;
import com.greetingsmessageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    /**
     * 1.Auto Wired all the required Classes to use the instance Objects globally.
     * 2.Created the Variables template and counter to use globally.
     */
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private GreetService greetService;
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    /**
     * 1. In This Method,
     *
     * @param name
     * @return - greeting Object.
     * @GetMapping = Annotation for mapping HTTP GET requests onto specific handler methods.
     * @RequestParam =  It is used to bind a web request parameter to a method parameter.
     * 2. If there is no value entered eg: " ", it takes default value if provided.
     * 3. return value will be Greeting Object with provided paramaters.
     */
    @GetMapping("/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * 1. In this Method,
     *
     * @RequestBody = allows us to retrieve the request's body.
     * 2. Then the body will be assumed as Passing userDto Object.
     * 3.While Returning, I am dividing variables of object and passing as string.
     */
    @GetMapping("/fullNameObject")
    public String greetFull(@RequestBody UserDto userDto) {

        return "Hello " + userDto.firstname + " " + userDto.lastname + ", welcome to my pgm";
    }

    /**
     * 1.In this Method, WE are Saving the Data into our Data Base.
     *
     * @PostMapping = Annotation for mapping HTTP POST requests onto specific handler methods.
     * 2. Then the body will be assumed as Passing userDto Object.
     * 3.Calling a Methods from Service Layer and passing the object into it.
     * 4. Here, I am Returning Saved Greet Message in dataBase to confirm.
     */
    @PostMapping("/add")
    public Greeting addUser(@RequestBody UserDto userdto) {

        userService.addUser(userdto);
        return greetService.addGreet(userdto);
    }

    /**
     * 1. This Method used for Retrieving all the Stored Data in our DataBase.
     * 2. The Return is List type, because The Returning value is list of Objects.
     * 3. Calling The inbuilt Method of Repository Created eg: findAll here..
     * 4. And returning it to visualize the data.
     */
    @GetMapping("/getall")
    public List<User> getUser() {

        return userRepo.findAll();
    }

    /**
     * 1. This Method used for Retrieving single Stored Data in our DataBase.
     * 2. The Return is Optional type, because The Returning value maybe Object or Null.
     * 3. Passing Path Variable as id to check for the id.
     * 3. Calling The inbuilt Method of Repository Created eg: findById here..
     * 4. And returning it to visualize the data.
     */
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable int id) {

        return userRepo.findById(id);
    }

    /**
     * 1. This Method used for Deleting single data in our DB.
     * 2. NO Return, just removes the object with passed ID.
     * 3. Calling The inbuilt Method of Repository Created eg: deleteById here..
     * 4. passing the id value into inbult function to delete.
     */

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {

        userRepo.deleteById(id);
    }

    /**
     * 1. This Method used for Updating Data by id.
     * 2. Passing the new Body to update the already Crated Body.
     * 2. The Return User type, because The Returning value is User type of Object.
     * 3. Calling The created Method of Service Layer Created.
     * 4. And returning it to visualize the data.
     */
    @PutMapping("/update")
    public User updateUser(@RequestBody UserDto userdto, @RequestParam int id) {

        User user = userService.updateUser(userdto, id);
        return user;
    }
}

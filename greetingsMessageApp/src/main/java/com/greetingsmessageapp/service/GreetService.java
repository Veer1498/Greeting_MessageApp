package com.greetingsmessageapp.service;

import com.greetingsmessageapp.Repo.GreetRepo;
import com.greetingsmessageapp.dto.UserDto;
import com.greetingsmessageapp.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
@Service
public class GreetService implements IGreetService {
    @Autowired
    private GreetRepo greetRepo;

    //    public Greeting getGreetByid(int id){
//        return greetRepo.findById(id).orElseThrow(() -> new UserException("User with Id " + id
//                + " Doesn't Exists...!"));
//    }

    /**
     * 1. This method is used for add greeting message to database.
     * 2. Passing the UserDto Object as parameter.
     * @param userDto
     * @return - saved greeting object.
     * 3.passing userdto Object as parameter for greeting constructor.
     * 4.it gets value and saved in greet variable.
     * 5. returning the saved Object and
     * Calling the inbuilt Save function by passing that greet object.
     */
    @Override
    public Greeting addGreet(UserDto userDto) {
        Greeting greet = new Greeting(userDto);
        return greetRepo.save(greet);
    }
}

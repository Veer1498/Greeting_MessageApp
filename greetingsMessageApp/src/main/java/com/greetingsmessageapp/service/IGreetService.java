package com.greetingsmessageapp.service;

import com.greetingsmessageapp.dto.UserDto;
import com.greetingsmessageapp.entity.Greeting;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
public interface IGreetService {
    public Greeting addGreet(UserDto userDto);
}

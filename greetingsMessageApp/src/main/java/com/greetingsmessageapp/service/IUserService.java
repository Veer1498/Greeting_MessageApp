package com.greetingsmessageapp.service;

import com.greetingsmessageapp.dto.UserDto;
import com.greetingsmessageapp.entity.User;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
public interface IUserService {
    public User addUser(UserDto userdto);

    public User getUserByid(int id);

    public User updateUser(UserDto userdto, int id);
}

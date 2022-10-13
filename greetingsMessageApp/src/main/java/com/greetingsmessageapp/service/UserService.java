package com.greetingsmessageapp.service;

import com.greetingsmessageapp.Repo.UserRepo;
import com.greetingsmessageapp.dto.UserDto;
import com.greetingsmessageapp.entity.User;
import com.greetingsmessageapp.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
@Service
public class UserService implements IUserService {
    /**
     * 1. Here, I have Created an UserService which is implementing from an interface.
     * 2. Autowired the Required Repository
     * 3.Created Different Methods to Control Business Logics.
     */
    @Autowired
    private UserRepo userRepo;

    /**
     *
     * @param userdto
     * @return saved User Object of user.
     */
    public User addUser(UserDto userdto) {
        User user = new User(userdto);
        return userRepo.save(user);
    }

    /**
     *  1. This Method is used for checking if required id is present or not.
     *  2. if ID is not present it throows a custom error.
     * @param id
     * @return a user object if available.
     */
    public User getUserByid(int id) {
        return userRepo.findById(id).orElseThrow(() -> new UserException("User with Id " + id
                + " Doesn't Exists...!"));
    }

    /**
     * 1. This method is used for updating the user data.
     * 2.passing both the parameters and checking if exits.
     * 3. if available changing that object with new passing object.
     * @param userdto
     * @param id
     * @return- the updated object or if any wrong occurs only nul will obtain.
     */
    public User updateUser(UserDto userdto, int id) {
        User user = this.getUserByid(id);
        if (user != null) {
            user.updateUser(userdto);
            return userRepo.save(user);
        }
        return null;
    }
}

package com.greetingsmessageapp.Repo;

import com.greetingsmessageapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}

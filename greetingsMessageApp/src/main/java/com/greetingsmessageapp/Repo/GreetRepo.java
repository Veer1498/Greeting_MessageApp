package com.greetingsmessageapp.Repo;

import com.greetingsmessageapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Puprose : To Create Greeting Message App and Perform CURL Operations on it
 * Author : Veer.Singa
 */
public interface GreetRepo extends JpaRepository<Greeting,Integer> {
}

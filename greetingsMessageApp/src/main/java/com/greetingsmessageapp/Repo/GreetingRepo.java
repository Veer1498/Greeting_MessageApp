package com.greetingsmessageapp.Repo;

import com.greetingsmessageapp.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepo extends JpaRepository<Model, Integer> {
}

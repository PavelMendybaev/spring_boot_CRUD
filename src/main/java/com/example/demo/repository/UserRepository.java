package com.example.demo.repository;

import com.example.demo.model.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "from User")
    List<User> getUsers();


    User getUserById(Long id);

}

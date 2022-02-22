package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.getUserById(id);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

}

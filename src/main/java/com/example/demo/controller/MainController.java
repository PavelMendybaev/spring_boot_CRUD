package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {


    private final UserService userService;
    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String Enter(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public String PostEnter(@RequestParam("username") String username , ModelMap model ) {
        userService.addUser(new User(username));
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("{id}")
    public String showUser(@PathVariable("id") Long id , ModelMap model){

        User user = userService.getUserById(id);
        model.addAttribute("user" , user);
        return "user";
    }


    @RequestMapping(value = "{id}" , method = RequestMethod.POST)
    public String getUser(@PathVariable("id") Long id ,@RequestParam("new_username") String new_name , ModelMap model){

        User user = userService.getUserById(id);
        user.setName(new_name);
        userService.update(user);
        model.addAttribute("user" , user);
        return "user";

    }
    @RequestMapping(value = "delete/{id}" , method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id , ModelMap model){

        userService.delete(userService.getUserById(id));

        return "delete";
    }
}

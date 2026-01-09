package com.avizva.app.controller;

import com.avizva.app.entity.User;
import com.avizva.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/id/{id}")
    public User getById(@PathVariable int id){
        return userService.getByUserId(id);
    }

    @GetMapping
    public String Test(){
        return "Ok";
    }

    @PostMapping
    public User addUser(@RequestBody User user){
            return userService.addUser(user);
    }

    @DeleteMapping("/all")
    public void removeUser(){
        userService.removeAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public void removeByID(@PathVariable int id){
        userService.removeById(id);
    }

    @PutMapping("/put/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return  userService.updateUser(id,user);
    }


}

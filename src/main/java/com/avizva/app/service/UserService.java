package com.avizva.app.service;

import com.avizva.app.entity.User;
import com.avizva.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
         return userRepository.addUser(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getByUserId(int id) {
    return userRepository.findById(id);
    }

    public void removeAllUser(){
         userRepository.deleteAll();
    }

    public void removeById(int id){
        userRepository.deleteById(id);
    }

    public User updateUser(int id,User user){
        User userToUpdate = userRepository.findById(id);
        if (userToUpdate == null) {
            throw new RuntimeException();
        }
        userToUpdate.setName(user.getName());
        userToUpdate.setGender(user.getGender());
        userToUpdate.setMaritalStatus(user.getMaritalStatus());

            return userRepository.save(userToUpdate);

    }
}

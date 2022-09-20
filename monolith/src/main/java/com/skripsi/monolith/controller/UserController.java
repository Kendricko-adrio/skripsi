package com.skripsi.monolith.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.monolith.dto.UserRequestDTO;
import com.skripsi.monolith.model.User;
import com.skripsi.monolith.repository.UserRepository;
import com.skripsi.monolith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @QueryMapping
    public User getUser(@Argument BigInteger id){
        return userService.getUser(id);
    }

    @QueryMapping(name = "getUserByUsername")
    public User getUserByUsername(@Argument String username){
        return userService.getUserByUsername(username);
    }

    @MutationMapping
    public User insertUser(@Argument UserRequestDTO input){
        return userService.insertUser(input);
    }

}

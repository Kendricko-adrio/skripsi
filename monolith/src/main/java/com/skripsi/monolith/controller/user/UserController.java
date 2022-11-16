package com.skripsi.monolith.controller.user;

import com.skripsi.monolith.dto.user.UserLoginDTO;
import com.skripsi.monolith.dto.user.UserRequestDTO;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.user.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @QueryMapping
    public User getUser(@Argument BigInteger id) {
        return userService.getUser(id);
    }

    @QueryMapping(name = "getUserByUsername")
    public User getUserByUsername(@Argument String username) {
        return userService.getUserByUsername(username);
    }

    @QueryMapping
    public Boolean checkUserLogin(@Argument UserLoginDTO user) {
        return userService.checkUserLogin(user);
    }

    @MutationMapping
    public User insertUser(@Argument UserRequestDTO input) {
        return userService.insertUser(input);
    }

    @MutationMapping
    public User updateUser(@Argument UserRequestDTO input) {
        return userService.updateUser(input);
    }
}

package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.model.request.user.UserLoginDTO;
import com.skripsi.graphqlserver.model.request.user.UserRequestDTO;
import com.skripsi.graphqlserver.model.user.User;
import com.skripsi.graphqlserver.model.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserClient userClient;

  @QueryMapping
  public List<User> getUsers() {
    return userClient.getUsers().getData();
  }

  @QueryMapping
  public User getUser(@Argument BigInteger id) {
    return userClient.getUser(id).getData();
  }

  @QueryMapping
  public User getUserByUsername(@Argument String username) {
    return userClient.getUserByUsername(username).getData();
  }

  @QueryMapping
  public Boolean checkUserLogin(@Argument UserLoginDTO user) {
    return userClient.checkUserLogin(user).getData();
  }

  @MutationMapping
  public User insertUser(@Argument UserRequestDTO input) {
    return userClient.insertUser(input).getData();
  }

  @MutationMapping
  public User updateUser(@Argument UserRequestDTO input) {
    return userClient.updateUser(input).getData();
  }

}

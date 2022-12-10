package com.skripsi.monolith.controller.user;

import com.skripsi.monolith.dto.user.UserLoginDTO;
import com.skripsi.monolith.dto.user.UserRequestDTO;
import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

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

  @SchemaMapping
  public User student(JobVacancy jobVacancy) {
    return userService.getUser(jobVacancy.getStudent().getId());
  }

  @SchemaMapping
  public User student(Order order) {
    return userService.getUser(order.getStudent().getId());
  }

  @SchemaMapping
  public User teacher(JobApplication jobApplication) {
    return userService.getUser(jobApplication.getTeacherId());
  }
}

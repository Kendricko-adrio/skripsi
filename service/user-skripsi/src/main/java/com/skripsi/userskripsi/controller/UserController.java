package com.skripsi.userskripsi.controller;


import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.dto.UserLoginDTO;
import com.skripsi.userskripsi.dto.UserRequestDTO;
import com.skripsi.userskripsi.model.User;
import com.skripsi.userskripsi.model.response.Response;
import com.skripsi.userskripsi.model.response.user.GetUserResponse;
import com.skripsi.userskripsi.service.UserService;
import com.skripsi.userskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;


  @GetMapping
  public Response<List<User>> getUsers() {
    return ResponseHandler.ok(userService.getUsers());
  }

  @GetMapping("/{id}")
  public Response<GetUserResponse> getUser(@PathVariable BigInteger id) {
    User user = userService.getUser(id);

    return ResponseHandler.ok(GetUserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .name(user.getName())
        .countryId(user.getCountry().getId())
        .roleId(user.getRole().getId())
        .build());
  }

  @GetMapping("/username/{username}")
  public Response<GetUserResponse> getUserByUsername(@PathVariable String username) {
    User user = userService.getUserByUsername(username);

    return ResponseHandler.ok(GetUserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .name(user.getName())
        .countryId(user.getCountry().getId())
        .roleId(user.getRole().getId())
        .build());
  }

  @PostMapping("/login")
  public Response<Boolean> checkUserLogin(@RequestBody UserLoginDTO user) {
    return ResponseHandler.ok(userService.checkUserLogin(user));
  }

  @PostMapping
  public Response<GetUserResponse> insertUser(@RequestBody UserRequestDTO input) {
    User user = userService.insertUser(input);
    return ResponseHandler.ok(GetUserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .name(user.getName())
        .countryId(user.getCountry().getId())
        .roleId(user.getRole().getId())
        .build());
  }


  @PutMapping
  public Response<GetUserResponse> updateUser(@RequestBody UserRequestDTO input) {
    User user = userService.updateUser(input);

    return ResponseHandler.ok(GetUserResponse.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .name(user.getName())
        .countryId(user.getCountry().getId())
        .roleId(user.getRole().getId())
        .build());
  }

  //  @SchemaMapping
  //  public User student(JobVacancy jobVacancy) {
  //    return userService.getUser(jobVacancy.getStudent().getId());
  //  }

  //  @SchemaMapping
  //  public User student(Order order) {
  //    return userService.getUser(order.getStudent().getId());
  //  }

  //  @SchemaMapping
  //  public User teacher(JobApplication jobApplication) {
  //    return userService.getUser(jobApplication.getTeacherId());
  //  }
}

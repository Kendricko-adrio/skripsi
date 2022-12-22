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
  public Response<User> getUser(@PathVariable BigInteger id) {
    return ResponseHandler.ok(userService.getUser(id));
  }

  @GetMapping("/username/{username}")
  public Response<User> getUserByUsername(@PathVariable String username) {
    return ResponseHandler.ok(userService.getUserByUsername(username));
  }

  @PostMapping("/login")
  public Response<Boolean> checkUserLogin(@RequestBody UserLoginDTO user) {
    return ResponseHandler.ok(userService.checkUserLogin(user));
  }

  @PostMapping
  public Response<User> insertUser(@RequestBody UserRequestDTO input) {
    return ResponseHandler.ok(userService.insertUser(input));
  }


  @PutMapping
  public Response<User> updateUser(@RequestBody UserRequestDTO input) {
    return ResponseHandler.ok(userService.updateUser(input));
  }
}

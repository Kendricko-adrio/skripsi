package com.skripsi.userskripsi.controller;


import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.dto.UserLoginDTO;
import com.skripsi.userskripsi.dto.UserRequestDTO;
import com.skripsi.userskripsi.model.User;
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


//    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,);

    //  @QueryMapping
    @GetMapping
    public ResponseEntity<BaseResponse> getUsers() {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, userService.getUsers());
    }

//  @QueryMapping
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getUser(@PathVariable BigInteger id)
    {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,userService.getUser(id));
    }

    //  @QueryMapping(name = "getUserByUsername")
    @GetMapping("/username/{username}")
    public ResponseEntity<BaseResponse> getUserByUsername(@PathVariable String username) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,userService.getUserByUsername(username));
    }

    //  @QueryMapping
    @PostMapping("/login")
    public ResponseEntity<BaseResponse> checkUserLogin(@RequestBody UserLoginDTO user) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,userService.checkUserLogin(user));
    }

    //  @MutationMapping
    @PostMapping
    public ResponseEntity<BaseResponse> insertUser(@RequestBody UserRequestDTO input) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,userService.insertUser(input));
    }

    //  @MutationMapping
    @PutMapping
    public ResponseEntity<BaseResponse> updateUser(@RequestBody UserRequestDTO input) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,userService.updateUser(input));
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

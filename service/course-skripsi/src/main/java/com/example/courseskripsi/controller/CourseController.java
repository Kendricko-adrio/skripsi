package com.example.courseskripsi.controller;

import com.example.courseskripsi.constant.ResponseMessage;
import com.example.courseskripsi.dto.BaseResponse;
import com.example.courseskripsi.dto.CourseInput;
import com.example.courseskripsi.model.Course;
import com.example.courseskripsi.service.CourseService;
import com.example.courseskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<BaseResponse> getCourses() {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getCourse(@PathVariable BigInteger id) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, courseService.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertCourse(@RequestBody CourseInput input) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, courseService.insertCourse(input));
    }

    @PutMapping("")
    public ResponseEntity<BaseResponse> updateCourse(@RequestBody CourseInput input) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, courseService.updateCourse(input));
    }
}

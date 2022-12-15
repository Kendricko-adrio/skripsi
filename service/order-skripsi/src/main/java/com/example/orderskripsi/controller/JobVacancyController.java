package com.example.orderskripsi.controller;

import com.example.orderskripsi.constant.ResponseMessage;
import com.example.orderskripsi.dto.BaseResponse;
import com.example.orderskripsi.dto.jobvacancy.CreateJobVacancyRequest;
import com.example.orderskripsi.dto.jobvacancy.DeleteJobVacancyRequest;
import com.example.orderskripsi.dto.jobvacancy.UpdateJobVacancyRequest;
import com.example.orderskripsi.model.JobApplication;
import com.example.orderskripsi.model.JobVacancy;
import com.example.orderskripsi.service.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import util.ResponseHandler;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/job-vacancy")
public class JobVacancyController {

    @Autowired
    private JobVacancyService jobVacancyService;

    //  @QueryMapping
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getJobVacancy(@PathVariable BigInteger id) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.getJobVacancy(id));
    }

    //  @QueryMapping
    @GetMapping
    public ResponseEntity<BaseResponse> getJobVacancies() {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.getJobVacancies());
    }

    //  @QueryMapping
    @GetMapping("/user/{id}")
    public ResponseEntity<BaseResponse> getJobVacancyByUser(@PathVariable BigInteger id) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.getJobVacanciesByStudent(id));
    }

    //  @MutationMapping
    @PostMapping
    public ResponseEntity<BaseResponse> createJobVacancy(@RequestBody CreateJobVacancyRequest request) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.createJobVacancy(request));
    }

    //  @MutationMapping
    @PutMapping
    public ResponseEntity<BaseResponse> updateJobVacancy(@RequestBody UpdateJobVacancyRequest request) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.updateJobVacancy(request));
    }

    //  @MutationMapping
    @DeleteMapping
    public ResponseEntity<BaseResponse> deleteJobVacancy(@RequestBody DeleteJobVacancyRequest request) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, jobVacancyService.deleteJobVacancy(request));
    }

//  @SchemaMapping
//  public List<JobVacancy> jobVacancies(User user) {
//    return jobVacancyService.getJobVacanciesByStudent(user.getId());
//  }

    //  @SchemaMapping
//    public JobVacancy jobVacancy(JobApplication jobApplication) {
//        return jobVacancyService.getJobVacancy(jobApplication.getJobVacancyId());
//    }
}

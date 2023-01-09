package com.example.orderskripsi.controller;

import com.example.orderskripsi.constant.ResponseMessage;
import com.example.orderskripsi.dto.BaseResponse;
import com.example.orderskripsi.dto.jobapplication.AcceptJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.CreateJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.RejectJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.WithdrawJobApplicationRequest;
import com.example.orderskripsi.model.JobApplication;
import com.example.orderskripsi.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.ResponseHandler;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/job-application")
public class JobApplicationController {

  @Autowired
  private JobApplicationService jobApplicationService;

  @GetMapping
  public ResponseEntity<BaseResponse> getJobApplications(@RequestParam BigInteger jobVacancyId,
      @RequestParam BigInteger teacherId) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.getJobApplications(jobVacancyId, teacherId));
  }

  @GetMapping("/teacher")
  public ResponseEntity<BaseResponse> getJobApplicationsByTeacher(@RequestParam BigInteger teacherId) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.getJobApplicationsByTeacher(teacherId));
  }

  @GetMapping("/student")
  public ResponseEntity<BaseResponse> getJobApplicationsByStudent(@RequestParam BigInteger studentId) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.getJobApplicationsByStudent(studentId));
  }

  @PostMapping
  public ResponseEntity<BaseResponse> createJobApplication(@RequestBody CreateJobApplicationRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.createJobApplication(request));
  }

  @PutMapping("/reject")
  public ResponseEntity<BaseResponse> rejectJobApplication(@RequestBody RejectJobApplicationRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.rejectJobApplication(request));

  }

  @PutMapping("/withdraw")
  public ResponseEntity<BaseResponse> withdrawJobApplication(@RequestBody WithdrawJobApplicationRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.withdrawJobApplication(request));
  }

  @PutMapping("/accept")
  public ResponseEntity<BaseResponse> acceptJobApplication(@RequestBody AcceptJobApplicationRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.acceptJobApplication(request));
  }

  @GetMapping("job-vacancy/{id}")
  public ResponseEntity<BaseResponse> jobApplications(@PathVariable BigInteger id) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        jobApplicationService.getJobApplicationsByJobVacancy(id));
  }

}

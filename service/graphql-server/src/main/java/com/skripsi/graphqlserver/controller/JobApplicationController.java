package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.order.JobApplicationClient;
import com.skripsi.graphqlserver.model.order.JobApplication;
import com.skripsi.graphqlserver.model.order.JobVacancy;
import com.skripsi.graphqlserver.model.request.order.jobapplication.AcceptJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.CreateJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.RejectJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.WithdrawJobApplicationRequest;
import com.skripsi.graphqlserver.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class JobApplicationController {

  @Autowired
  private JobApplicationClient jobApplicationClient;

  @QueryMapping
  public List<JobApplication> getJobApplications(@Argument BigInteger jobVacancyId,
      @Argument BigInteger teacherId) {
    return jobApplicationClient.getJobApplications(jobVacancyId, teacherId).getData();
  }

  @QueryMapping
  public List<JobApplication> getJobApplicationByTeacher(@Argument BigInteger id) {
    return jobApplicationClient.getJobApplicationByTeacher(id).getData();
  }

  @QueryMapping
  public List<JobApplication> getJobApplicationByStudent(@Argument BigInteger id) {
    return jobApplicationClient.getJobApplicationByStudent(id).getData();
  }

  @MutationMapping
  public JobApplication createJobApplication(@Argument CreateJobApplicationRequest request) {
    return jobApplicationClient.createJobApplication(request).getData();
  }

  @MutationMapping
  public Boolean rejectJobApplication(@Argument RejectJobApplicationRequest request) {
    return jobApplicationClient.rejectJobApplication(request).getData();
  }

  @MutationMapping
  public Boolean withdrawJobApplication(@Argument WithdrawJobApplicationRequest request) {
    return jobApplicationClient.withdrawJobApplication(request).getData();
  }

  @MutationMapping
  public Boolean acceptJobApplication(@Argument AcceptJobApplicationRequest request) {
    return jobApplicationClient.acceptJobApplication(request).getData();
  }

  @SchemaMapping
  public List<JobApplication> jobApplications(User teacher) {
    return jobApplicationClient.getJobApplicationByTeacher(teacher.getId()).getData();
  }

  @SchemaMapping
  public List<JobApplication> jobApplications(JobVacancy jobVacancy) {
    return jobApplicationClient.getJobApplicationByJobVacancy(jobVacancy.getId()).getData();
  }

}

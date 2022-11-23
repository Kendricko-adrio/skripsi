package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.user.jobapplication.AcceptJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.CreateJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.RejectJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.WithdrawJobApplicationRequest;
import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.order.JobApplicationService;
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
  private JobApplicationService jobApplicationService;

  @QueryMapping
  public List<JobApplication> getJobApplications(@Argument BigInteger jobVacancyId,
      @Argument BigInteger tutorId) {
    return jobApplicationService.getJobApplications(jobVacancyId, tutorId);
  }

  @QueryMapping
  public List<JobApplication> getJobApplicationsByTutor(@Argument BigInteger tutorId) {
    return jobApplicationService.getJobApplicationsByTutor(tutorId);
  }

  @MutationMapping
  public JobApplication createJobApplication(@Argument CreateJobApplicationRequest request) {
    return jobApplicationService.createJobApplication(request);
  }

  @MutationMapping
  public Boolean rejectJobApplication(@Argument RejectJobApplicationRequest request) {
    return jobApplicationService.rejectJobApplication(request);
  }

  @MutationMapping
  public Boolean withdrawJobApplication(@Argument WithdrawJobApplicationRequest request) {
    return jobApplicationService.withdrawJobApplication(request);
  }

  @MutationMapping
  public Boolean acceptJobApplication(@Argument AcceptJobApplicationRequest request) {
    return jobApplicationService.acceptJobApplication(request);
  }

  @SchemaMapping
  public List<JobApplication> jobApplications(User tutor) {
    return jobApplicationService.getJobApplicationsByTutor(tutor.getId());
  }

  @SchemaMapping
  public List<JobApplication> jobApplications(JobVacancy jobVacancy) {
    return jobApplicationService.getJobApplicationsByJobVacancy(jobVacancy.getId());
  }

}

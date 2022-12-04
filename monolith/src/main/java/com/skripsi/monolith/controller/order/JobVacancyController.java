package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.user.jobvacancy.CreateJobVacancyRequest;
import com.skripsi.monolith.dto.user.jobvacancy.DeleteJobVacancyRequest;
import com.skripsi.monolith.dto.user.jobvacancy.UpdateJobVacancyRequest;
import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.order.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class JobVacancyController {

  @Autowired
  private JobVacancyService jobVacancyService;

  @QueryMapping
  public JobVacancy getJobVacancy(@Argument BigInteger id) {
    return jobVacancyService.getJobVacancy(id);
  }

  @QueryMapping
  public List<JobVacancy> getJobVacancies() {
    return jobVacancyService.getJobVacancies();
  }

  @QueryMapping
  public List<JobVacancy> getJobVacancyByUser(@Argument BigInteger id) {
    return jobVacancyService.getJobVacanciesByStudent(id);
  }

  @MutationMapping
  public JobVacancy createJobVacancy(@Argument CreateJobVacancyRequest request) {
    return jobVacancyService.createJobVacancy(request);
  }

  @MutationMapping
  public JobVacancy updateJobVacancy(@Argument UpdateJobVacancyRequest request) {
    return jobVacancyService.updateJobVacancy(request);
  }

  @MutationMapping
  public Boolean deleteJobVacancy(@Argument DeleteJobVacancyRequest request) {
    return jobVacancyService.deleteJobVacancy(request);
  }

  @SchemaMapping
  public List<JobVacancy> jobVacancies(User user) {
    return jobVacancyService.getJobVacanciesByStudent(user.getId());
  }

  @SchemaMapping
  public JobVacancy jobVacancy(JobApplication jobApplication) {
    return jobVacancyService.getJobVacancy(jobApplication.getJobVacancyId());
  }
}

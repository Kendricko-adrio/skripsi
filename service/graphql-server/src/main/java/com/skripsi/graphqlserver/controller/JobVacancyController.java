package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.order.JobVacancyClient;
import com.skripsi.graphqlserver.model.order.JobVacancy;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.CreateJobVacancyRequest;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.DeleteJobVacancyRequest;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.UpdateJobVacancyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class JobVacancyController {

  @Autowired
  private JobVacancyClient jobVacancyClient;

  @QueryMapping
  public JobVacancy getJobVacancy(@Argument BigInteger id) {
    return jobVacancyClient.getJobVacancy(id).getData();
  }

  @QueryMapping
  public List<JobVacancy> getJobVacancies() {
    return jobVacancyClient.getJobVacancies().getData();
  }

  @QueryMapping
  public List<JobVacancy> getJobVacancyByUser(@Argument BigInteger id) {
    return jobVacancyClient.getJobVacancyByUser(id).getData();
  }

  @MutationMapping
  public JobVacancy createJobVacancy(@Argument CreateJobVacancyRequest jobVacancy) {
    return jobVacancyClient.createJobVacancy(jobVacancy).getData();
  }

  @MutationMapping
  public JobVacancy updateJobVacancy(@Argument UpdateJobVacancyRequest jobVacancy) {
    return jobVacancyClient.updateJobVacancy(jobVacancy).getData();
  }

  @MutationMapping
  public Boolean deleteJobVacancy(@Argument DeleteJobVacancyRequest id) {
    return jobVacancyClient.deleteJobVacancy(id).getData();
  }

}

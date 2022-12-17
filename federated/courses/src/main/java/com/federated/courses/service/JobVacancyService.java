package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.dto.jobvacancy.CreateJobVacancyRequest;
import com.federated.courses.dto.jobvacancy.DeleteJobVacancyRequest;
import com.federated.courses.dto.jobvacancy.UpdateJobVacancyRequest;
import com.federated.courses.model.Response;
import com.federated.courses.model.order.JobApplication;
import com.federated.courses.model.order.JobVacancy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class JobVacancyService extends ExternalBaseService {

  @Value("${external.vacancy.url}")
  private String vacancyUrl;

  private ObjectMapper mapper = new ObjectMapper();

  public JobVacancy getJobVacancy(BigInteger id) {
    Response response = hitExternalService(vacancyUrl + "/" + id, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), JobVacancy.class);
  }

  public List<JobVacancy> getJobVacancies() {
    Response response = hitExternalService(vacancyUrl, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, JobVacancy.class));
  }

  public List<JobVacancy> getJobVacanciesByStudent(BigInteger userId) {
    Response response = hitExternalService(vacancyUrl + "/user/" +  userId, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, JobVacancy.class));
  }

  public JobVacancy createJobVacancy(CreateJobVacancyRequest request) {
    return null;
  }

  public JobVacancy updateJobVacancy(UpdateJobVacancyRequest request) {
    return null;
  }

  public Boolean deleteJobVacancy(DeleteJobVacancyRequest request) {
    return null;
  }



}

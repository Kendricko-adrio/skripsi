package com.skripsi.graphqlserver.client.order;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.order.JobVacancy;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.CreateJobVacancyRequest;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.DeleteJobVacancyRequest;
import com.skripsi.graphqlserver.model.request.order.jobvacancy.UpdateJobVacancyRequest;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;


@Component
public class JobVacancyClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  public JobVacancyClient(RestTemplateBuilder builder) {
    super(builder);
  }

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getOrder();
  }

  public Response<JobVacancy> getJobVacancy(BigInteger id) {
    return get("job-vacancy/" + id, new ParameterizedTypeReference<Response<JobVacancy>>() {
    });
  }

  public Response<List<JobVacancy>> getJobVacancies() {
    return get("job-vacancy", new ParameterizedTypeReference<Response<List<JobVacancy>>>() {
    });
  }

  public Response<List<JobVacancy>> getJobVacancyByUser(BigInteger userId) {
    return get("job-vacancy/user/" + userId, new ParameterizedTypeReference<Response<List<JobVacancy>>>() {
    });
  }

  public Response<JobVacancy> createJobVacancy(CreateJobVacancyRequest request) {
    return post("job-vacancy", request, new ParameterizedTypeReference<Response<JobVacancy>>() {
    });
  }

  public Response<JobVacancy> updateJobVacancy(UpdateJobVacancyRequest request) {
    return put("job-vacancy", request, new ParameterizedTypeReference<Response<JobVacancy>>() {
    });
  }

  public Response<Boolean> deleteJobVacancy(DeleteJobVacancyRequest request) {
    return delete("job-vacancy", request, new ParameterizedTypeReference<Response<Boolean>>() {
    });
  }

}

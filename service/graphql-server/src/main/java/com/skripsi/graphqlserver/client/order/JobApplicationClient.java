package com.skripsi.graphqlserver.client.order;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.order.JobApplication;
import com.skripsi.graphqlserver.model.request.order.jobapplication.AcceptJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.CreateJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.RejectJobApplicationRequest;
import com.skripsi.graphqlserver.model.request.order.jobapplication.WithdrawJobApplicationRequest;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class JobApplicationClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  public JobApplicationClient(RestTemplateBuilder builder) {
    super(builder);
  }

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getOrder();
  }

  public Response<List<JobApplication>> getJobApplications(BigInteger jobVacancyId,
      BigInteger teacherId) {
    return get("job-application?jobVacancyId=" + jobVacancyId + "&teacherId=" + teacherId,
        new ParameterizedTypeReference<Response<List<JobApplication>>>() {
        });
  }

  public Response<List<JobApplication>> getJobApplicationByTeacher(BigInteger teacherId) {
    return get("job-application/teacher?teacherId=" + teacherId,
        new ParameterizedTypeReference<Response<List<JobApplication>>>() {
        });
  }

  public Response<List<JobApplication>> getJobApplicationByStudent(BigInteger studentId) {
    return get("job-application/student?studentId=" + studentId,
        new ParameterizedTypeReference<Response<List<JobApplication>>>() {
        });
  }

  public Response<List<JobApplication>> getJobApplicationByJobVacancy(BigInteger jobVacancyId) {
    return get("job-application/job-vacancy/" + jobVacancyId,
        new ParameterizedTypeReference<Response<List<JobApplication>>>() {
        });
  }

  public Response<JobApplication> createJobApplication(CreateJobApplicationRequest request) {
    return post("job-application",
        request,
        new ParameterizedTypeReference<Response<JobApplication>>() {
        });
  }

  public Response<Boolean> rejectJobApplication(RejectJobApplicationRequest request) {
    return put("job-application/reject",
        request,
        new ParameterizedTypeReference<Response<Boolean>>() {
        });
  }

  public Response<Boolean> withdrawJobApplication(WithdrawJobApplicationRequest request) {
    return put("job-application/withdraw",
        request,
        new ParameterizedTypeReference<Response<Boolean>>() {
        });
  }

  public Response<Boolean> acceptJobApplication(AcceptJobApplicationRequest request) {
    return put("job-application/accept",
        request,
        new ParameterizedTypeReference<Response<Boolean>>() {
        });
  }

}

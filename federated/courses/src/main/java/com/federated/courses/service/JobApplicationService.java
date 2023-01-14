package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.dto.jobapplication.AcceptJobApplicationRequest;
import com.federated.courses.dto.jobapplication.CreateJobApplicationRequest;
import com.federated.courses.dto.jobapplication.RejectJobApplicationRequest;
import com.federated.courses.dto.jobapplication.WithdrawJobApplicationRequest;
import com.federated.courses.dto.jobapplication.request.JobApplicationRequest;
import com.federated.courses.model.Course;
import com.federated.courses.model.Response;
import com.federated.courses.model.order.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class JobApplicationService extends ExternalBaseService{


    @Value("${external.application.url}")
    private String externalApplicationUrl;

    private ObjectMapper mapper = new ObjectMapper();

    public List<JobApplication> getJobApplications(BigInteger jobVacancyId, BigInteger teacherId) {
        String uri =
            externalApplicationUrl + "?jobVacancyId=" + jobVacancyId + "&teacherId=" + teacherId;
        Response response = hitExternalService(uri, HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(),
            mapper.getTypeFactory().constructCollectionType(List.class, JobApplication.class));
    }

    public List<JobApplication> getJobApplicationsByJobVacancy(BigInteger jobVacancyId) {
        Response response = hitExternalService(externalApplicationUrl + "/job-vacancy/" +  jobVacancyId, HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, JobApplication.class));
    }

    public List<JobApplication> getJobApplicationsByTeacher(BigInteger teacherId) {
        Response response = hitExternalService(externalApplicationUrl + "/teacher?teacherId=" +  teacherId, HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, JobApplication.class));
    }

    public JobApplication createJobApplication(CreateJobApplicationRequest request) {
        JobApplicationRequest jobApplicationRequest = inputToRequest(request);
        Response response = hitExternalService(externalApplicationUrl, HttpMethod.POST, jobApplicationRequest, null, Response.class);
        return mapper.convertValue(response.getData(), JobApplication.class);
    }

    public Boolean rejectJobApplication(RejectJobApplicationRequest request) {
        JobApplicationRequest jobApplicationRequest = inputToRequest(request);
        Response response = hitExternalService(externalApplicationUrl+"/reject", HttpMethod.PUT, jobApplicationRequest, null, Response.class);
        return mapper.convertValue(response.getData(), Boolean.class);
    }

    public Boolean withdrawJobApplication(WithdrawJobApplicationRequest request) {
        JobApplicationRequest jobApplicationRequest = inputToRequest(request);
        Response response = hitExternalService(externalApplicationUrl+"/withdraw", HttpMethod.PUT, jobApplicationRequest, null, Response.class);
        return mapper.convertValue(response.getData(), Boolean.class);
    }

    public Boolean acceptJobApplication(AcceptJobApplicationRequest request) {
        JobApplicationRequest jobApplicationRequest = inputToRequest(request);
        Response response = hitExternalService(externalApplicationUrl+"/accept", HttpMethod.PUT, jobApplicationRequest, null, Response.class);
        return mapper.convertValue(response.getData(), Boolean.class);
    }

    private JobApplicationRequest inputToRequest(CreateJobApplicationRequest input){
        return JobApplicationRequest.builder()
                .jobVacancyId(input.getJobVacancyId() == null ? null : new BigInteger(input.getJobVacancyId()))
                .teacherId(input.getTeacherId() == null ? null : new BigInteger(input.getTeacherId()))
                .build();
    }
    private JobApplicationRequest inputToRequest(AcceptJobApplicationRequest input){
        return JobApplicationRequest.builder()
                .jobVacancyId(input.getJobVacancyId() == null ? null : new BigInteger(input.getJobVacancyId()))
                .teacherId(input.getTeacherId() == null ? null : new BigInteger(input.getTeacherId()))
                .build();
    }
    private JobApplicationRequest inputToRequest(WithdrawJobApplicationRequest input){
        return JobApplicationRequest.builder()
                .jobVacancyId(input.getJobVacancyId() == null ? null : new BigInteger(input.getJobVacancyId()))
                .teacherId(input.getTeacherId() == null ? null : new BigInteger(input.getTeacherId()))
                .build();
    }
    private JobApplicationRequest inputToRequest(RejectJobApplicationRequest input){
        return JobApplicationRequest.builder()
                .jobVacancyId(input.getJobVacancyId() == null ? null : new BigInteger(input.getJobVacancyId()))
                .teacherId(input.getTeacherId() == null ? null : new BigInteger(input.getTeacherId()))
                .build();
    }


}

package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.dto.jobvacancy.*;
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
        Response response = hitExternalService(vacancyUrl + "/user/" + userId, HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, JobVacancy.class));
    }

    public JobVacancy createJobVacancy(CreateJobVacancyRequest request) {
        Response response = hitExternalService(vacancyUrl, HttpMethod.POST, inputToExternalRequest(request), null, Response.class);
        return mapper.convertValue(response.getData(), JobVacancy.class);
    }

    public JobVacancy updateJobVacancy(UpdateJobVacancyRequest request) {
        Response response = hitExternalService(vacancyUrl, HttpMethod.PUT, inputToExternalRequest(request), null, Response.class);
        return mapper.convertValue(response.getData(), JobVacancy.class);
    }

    public Boolean deleteJobVacancy(DeleteJobVacancyRequest request) {
        Response response = hitExternalService(vacancyUrl, HttpMethod.DELETE, inputToExternalRequest(request), null, Response.class);
        return mapper.convertValue(response.getData(), Boolean.class);
    }

    private JobVacancyExternalRequest inputToExternalRequest(CreateJobVacancyRequest request) {
        return JobVacancyExternalRequest.builder()
                .courseId(new BigInteger(request.getCourseId()))
                .studentId(new BigInteger(request.getStudentId()))
                .description(request.getDescription())
                .build();
    }

    private JobVacancyUpdateRequest inputToExternalRequest(UpdateJobVacancyRequest request) {
        return JobVacancyUpdateRequest.builder()
                .id(new BigInteger(request.getId()))
                .description(request.getDescription())
                .isActive(request.getIsActive())
                .build();
    }

    private JobVacancyDeleteRequest inputToExternalRequest(DeleteJobVacancyRequest request) {
//        JobVacancy jv = getJobVacancy(new BigInteger(request.getId()));
        return JobVacancyDeleteRequest.builder()
                .id(new BigInteger(request.getId()))
//                .isActive(jv.getIsActive())
//                .description(jv.getDescription())
                .build();
    }

}

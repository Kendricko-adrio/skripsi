package com.federated.courses.dgs;


import com.federated.courses.dto.jobapplication.AcceptJobApplicationRequest;
import com.federated.courses.dto.jobapplication.CreateJobApplicationRequest;
import com.federated.courses.dto.jobapplication.RejectJobApplicationRequest;
import com.federated.courses.dto.jobapplication.WithdrawJobApplicationRequest;
import com.federated.courses.model.User;
import com.federated.courses.model.order.JobApplication;
import com.federated.courses.model.order.JobVacancy;
import com.federated.courses.service.JobApplicationService;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@DgsComponent
public class JobApplicationDataFetcher {

    @Autowired
    private JobApplicationService jobApplicationService;

    @DgsQuery
    public List<JobApplication> getJobApplications(@InputArgument String jobVacancyId,
        @InputArgument String teacherId) {
        return jobApplicationService.getJobApplications(new BigInteger(jobVacancyId), new BigInteger(teacherId));
    }

    @DgsQuery
    public List<JobApplication> getJobApplicationsByTeacher(@InputArgument String teacherId) {
        return jobApplicationService.getJobApplicationsByTeacher(new BigInteger(teacherId));
    }
    @DgsQuery
    public List<JobApplication> getJobApplicationsByStudent(@InputArgument String studentId) {
        return jobApplicationService.getJobApplicationsByStudent(new BigInteger(studentId));
    }

    @DgsMutation
    public JobApplication createJobApplication(@InputArgument CreateJobApplicationRequest request) {
        return jobApplicationService.createJobApplication(request);
    }

    @DgsMutation
    public Boolean rejectJobApplication(@InputArgument RejectJobApplicationRequest request) {
        return jobApplicationService.rejectJobApplication(request);
    }

    @DgsMutation
    public Boolean withdrawJobApplication(@InputArgument WithdrawJobApplicationRequest request) {
        return jobApplicationService.withdrawJobApplication(request);
    }

    @DgsMutation
    public Boolean acceptJobApplication(@InputArgument AcceptJobApplicationRequest request) {
        return jobApplicationService.acceptJobApplication(request);
    }

//    @SchemaMapping
//    public List<JobApplication> jobApplications(User teacher) {
//        return jobApplicationService.getJobApplicationsByTeacher(teacher.getId());
//    }

    @DgsData(parentType = "JobVacancy")
    public List<JobApplication> jobApplications(DgsDataFetchingEnvironment dfe) {
        JobVacancy jobVacancy = dfe.getSource();
        return jobApplicationService.getJobApplicationsByJobVacancy(jobVacancy.getId());
    }

    @DgsEntityFetcher(name = "User")
    public User getUserById(Map<String, Object> values) {
        String id = (String) values.get("id");
        return new User(new BigInteger(id));
    }
}

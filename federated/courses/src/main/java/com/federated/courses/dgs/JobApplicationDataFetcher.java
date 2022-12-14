package com.federated.courses.dgs;


import com.federated.courses.dto.jobapplication.AcceptJobApplicationRequest;
import com.federated.courses.dto.jobapplication.CreateJobApplicationRequest;
import com.federated.courses.dto.jobapplication.RejectJobApplicationRequest;
import com.federated.courses.dto.jobapplication.WithdrawJobApplicationRequest;
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

@DgsComponent
public class JobApplicationDataFetcher {

    @Autowired
    private JobApplicationService jobApplicationService;

    // gtw ini bwt apa
    @DgsQuery
    public List<JobApplication> getJobApplications(@InputArgument BigInteger jobVacancyId,
                                                   @InputArgument BigInteger teacherId) {
        return jobApplicationService.getJobApplications(jobVacancyId, teacherId);
    }

    @DgsQuery
    public List<JobApplication> getJobApplicationByTeacher(@InputArgument String teacherId) {
        return jobApplicationService.getJobApplicationsByTeacher(new BigInteger(teacherId));
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


//
//    @SchemaMapping
//    public List<JobApplication> jobApplications(JobVacancy jobVacancy) {
//        return jobApplicationService.getJobApplicationsByJobVacancy(jobVacancy.getId());
//    }
    @DgsData(parentType = "JobVacancy")
    public List<JobApplication> jobApplications(DgsDataFetchingEnvironment dfe) {
        JobVacancy jobVacancy = dfe.getSource();
        return jobApplicationService.getJobApplicationsByJobVacancy(jobVacancy.getId());
    }
}

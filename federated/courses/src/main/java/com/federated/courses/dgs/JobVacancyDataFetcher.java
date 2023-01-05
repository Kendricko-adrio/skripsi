package com.federated.courses.dgs;

import com.federated.courses.dto.jobvacancy.CreateJobVacancyRequest;
import com.federated.courses.dto.jobvacancy.DeleteJobVacancyRequest;
import com.federated.courses.dto.jobvacancy.UpdateJobVacancyRequest;
import com.federated.courses.model.User;
import com.federated.courses.model.order.JobVacancy;
import com.federated.courses.service.JobVacancyService;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@DgsComponent
public class JobVacancyDataFetcher {


    @Autowired
    private JobVacancyService jobVacancyService;

    @DgsQuery
    public JobVacancy getJobVacancy(@InputArgument String id) {
        return jobVacancyService.getJobVacancy(new BigInteger(id));
    }

    @DgsQuery
    public List<JobVacancy> getJobVacancies() {
        return jobVacancyService.getJobVacancies();
    }

    @DgsQuery
    public List<JobVacancy> getJobVacancyByUser(@InputArgument String id) {
        return jobVacancyService.getJobVacanciesByStudent(new BigInteger(id));
    }

    @DgsMutation
    public JobVacancy createJobVacancy(@InputArgument CreateJobVacancyRequest request) {
        return jobVacancyService.createJobVacancy(request);
    }

    @DgsMutation
    public JobVacancy updateJobVacancy(@InputArgument UpdateJobVacancyRequest request) {
        return jobVacancyService.updateJobVacancy(request);
    }

    @DgsMutation
    public Boolean deleteJobVacancy(@InputArgument DeleteJobVacancyRequest request) {
        return jobVacancyService.deleteJobVacancy(request);
    }

    //    @SchemaMapping
//    public List<JobVacancy> jobVacancies(User user) {
//        return jobVacancyService.getJobVacanciesByStudent(user.getId());
//    }
    @DgsData(parentType = "User")
    public List<JobVacancy> jobVacancies(DgsDataFetchingEnvironment dfe) {
        User user = dfe.getSource();
        return jobVacancyService.getJobVacanciesByStudent(user.getId());
    }

    @DgsEntityFetcher(name = "User")
    public User getUserById(Map<String, Object> values) {
        String id = (String) values.get("id");
        return new User(new BigInteger(id));
    }

    //
//    @SchemaMapping
//    public JobVacancy jobVacancy(JobApplication jobApplication) {
//        return jobVacancyService.getJobVacancy(jobApplication.getJobVacancyId());
//    }
}

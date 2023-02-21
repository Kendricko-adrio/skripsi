package com.example.orderskripsi.service;

import com.example.orderskripsi.dto.jobvacancy.CreateJobVacancyRequest;
import com.example.orderskripsi.dto.jobvacancy.DeleteJobVacancyRequest;
import com.example.orderskripsi.dto.jobvacancy.UpdateJobVacancyRequest;
import com.example.orderskripsi.model.JobVacancy;
import com.example.orderskripsi.repository.JobApplicationRepository;
import com.example.orderskripsi.repository.JobVacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class JobVacancyService {

  @Autowired
  private JobVacancyRepository jobVacancyRepository;

  @Autowired
  private JobApplicationRepository jobApplicationRepository;

//  @Autowired
//  private CourseRepository courseRepository;

//  @Autowired
//  private UserRepository userRepository;

  public JobVacancy getJobVacancy(BigInteger id) {
    return jobVacancyRepository.findById(id).orElse(null);
  }

  public List<JobVacancy> getJobVacancies() {
    return jobVacancyRepository.findAllByMarkForDeleteFalse();
  }

  public List<JobVacancy> getJobVacanciesByStudent(BigInteger userId) {
    return jobVacancyRepository.findAllByStudentIdAndMarkForDeleteFalse(userId);
  }

  public JobVacancy createJobVacancy(CreateJobVacancyRequest request) {
    JobVacancy jobVacancy = JobVacancy.builder()
            .courseId(request.getCourseId())
        .studentId(request.getStudentId())
        .description(request.getDescription())
            .isActive(true)
        .build();
    return jobVacancyRepository.save(jobVacancy);
  }

  public JobVacancy updateJobVacancy(UpdateJobVacancyRequest request) {
    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getId()).get();
    jobVacancy.setDescription(request.getDescription());
    jobVacancy.setIsActive(request.getIsActive());
    return jobVacancyRepository.save(jobVacancy);
  }

  public Boolean deleteJobVacancy(DeleteJobVacancyRequest request) {
    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getId()).get();
    jobVacancy.setMarkForDelete(Boolean.TRUE);
    jobVacancyRepository.save(jobVacancy);
    return Boolean.TRUE;
//    log.info("HERE");
//    return jobVacancyRepository.save(jobVacancy);
  }



}

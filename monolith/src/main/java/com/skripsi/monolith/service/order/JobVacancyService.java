package com.skripsi.monolith.service.order;

import com.skripsi.monolith.dto.user.jobvacancy.CreateJobVacancyRequest;
import com.skripsi.monolith.dto.user.jobvacancy.DeleteJobVacancyRequest;
import com.skripsi.monolith.dto.user.jobvacancy.UpdateJobVacancyRequest;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.repository.course.CourseRepository;
import com.skripsi.monolith.repository.order.JobApplicationRepository;
import com.skripsi.monolith.repository.order.JobVacancyRepository;
import com.skripsi.monolith.repository.user.UserRepository;
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

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private UserRepository userRepository;

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
        .course(courseRepository.findById(request.getCourseId()).orElse(null))
        .student(userRepository.findById(request.getStudentId()).orElse(null))
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
  }



}

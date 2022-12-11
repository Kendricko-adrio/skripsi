package com.example.orderskripsi.service;

import com.example.orderskripsi.dto.jobapplication.AcceptJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.CreateJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.RejectJobApplicationRequest;
import com.example.orderskripsi.dto.jobapplication.WithdrawJobApplicationRequest;
import com.example.orderskripsi.external.NotificationService;
import com.example.orderskripsi.model.JobApplication;
import com.example.orderskripsi.model.JobApplicationId;
import com.example.orderskripsi.model.JobVacancy;
import com.example.orderskripsi.model.constants.JobApplicationStatus;
import com.example.orderskripsi.model.constants.NotificationStatus;
import com.example.orderskripsi.repository.JobApplicationRepository;
import com.example.orderskripsi.repository.JobVacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class JobApplicationService {

  @Autowired
  private JobApplicationRepository jobApplicationRepository;

  @Autowired
  private NotificationService notificationService;

  @Autowired
  private JobVacancyRepository jobVacancyRepository;

  @Autowired
  private OrderService orderService;


  public List<JobApplication> getJobApplications(BigInteger jobVacancyId, BigInteger teacherId) {
    return jobApplicationRepository.findAllByJobVacancyIdAndTeacherIdAndMarkForDeleteFalse(
        jobVacancyId,
        teacherId);
  }

  public List<JobApplication> getJobApplicationsByJobVacancy(BigInteger jobVacancyId) {
    return jobApplicationRepository.findAllByJobVacancyIdAndMarkForDeleteFalse(jobVacancyId);
  }

  public List<JobApplication> getJobApplicationsByTeacher(BigInteger teacherId) {
    return jobApplicationRepository.findAllByTeacherIdAndMarkForDeleteFalse(teacherId);
  }

  public JobApplication createJobApplication(CreateJobApplicationRequest request) {
    JobApplication jobApplication = JobApplication.builder()
        .jobVacancyId(request.getJobVacancyId())
        .teacherId(request.getTeacherId())
        .approvalStatus(JobApplicationStatus.PENDING)
        .build();

    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getJobVacancyId()).get();
    notificationService.saveJobApplicationNotification(jobVacancy.getStudentId(),
        NotificationStatus.JOB_APPLICATION_NEW);

    return jobApplicationRepository.save(jobApplication);
  }

  public Boolean rejectJobApplication(RejectJobApplicationRequest request) {
    JobApplication jobApplication = jobApplicationRepository.findById(JobApplicationId.builder()
        .jobVacancyId(request.getJobVacancyId())
        .teacherId(request.getTeacherId())
        .build()).get();
    jobApplication.setApprovalStatus(JobApplicationStatus.REJECTED_BY_STUDENT);
    jobApplicationRepository.save(jobApplication);

    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getJobVacancyId()).get();
    notificationService.saveJobApplicationNotification(jobVacancy.getStudentId(),
        NotificationStatus.JOB_APPLICATION_REJECTION);

    return true;
  }

  public Boolean withdrawJobApplication(WithdrawJobApplicationRequest request) {
    JobApplication jobApplication = jobApplicationRepository.findById(JobApplicationId.builder()
        .jobVacancyId(request.getJobVacancyId())
        .teacherId(request.getTeacherId())
        .build()).get();
    jobApplication.setApprovalStatus(JobApplicationStatus.CANCELLED_BY_TEACHER);
    jobApplicationRepository.save(jobApplication);

    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getJobVacancyId()).get();
    notificationService.saveJobApplicationNotification(jobVacancy.getStudentId(),
        NotificationStatus.JOB_APPLICATION_WITHDRAW);

    return true;
  }

  public Boolean acceptJobApplication(AcceptJobApplicationRequest request) {
    JobApplication jobApplication = jobApplicationRepository.findById(JobApplicationId.builder()
        .jobVacancyId(request.getJobVacancyId())
        .teacherId(request.getTeacherId())
        .build()).get();
    jobApplication.setApprovalStatus(JobApplicationStatus.APPROVED);
    jobApplicationRepository.save(jobApplication);

    JobVacancy jobVacancy = jobVacancyRepository.findById(request.getJobVacancyId()).get();
    notificationService.saveJobApplicationNotification(jobVacancy.getStudentId(),
        NotificationStatus.JOB_APPLICATION_ACCEPTANCE);

    orderService.createOrder(jobVacancy, request.getTeacherId());
    return true;
  }

}

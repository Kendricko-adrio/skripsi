package com.skripsi.monolith.service.order;

import com.skripsi.monolith.dto.user.jobapplication.AcceptJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.CreateJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.RejectJobApplicationRequest;
import com.skripsi.monolith.dto.user.jobapplication.WithdrawJobApplicationRequest;
import com.skripsi.monolith.model.constants.JobApplicationStatus;
import com.skripsi.monolith.model.constants.NotificationStatus;
import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.repository.order.JobApplicationRepository;
import com.skripsi.monolith.repository.order.JobVacancyRepository;
import com.skripsi.monolith.repository.user.UserRepository;
import com.skripsi.monolith.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @Autowired
    private UserRepository userRepository;

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
        notificationService.saveJobApplicationNotification(jobVacancy.getStudent(),
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

        User teacher = userRepository.findById(request.getTeacherId()).orElse(null);
        notificationService.saveJobApplicationNotification(teacher,
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
        notificationService.saveJobApplicationNotification(jobVacancy.getStudent(),
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
        User teacher = userRepository.findById(request.getTeacherId()).orElse(null);
        notificationService.saveJobApplicationNotification(teacher,
                NotificationStatus.JOB_APPLICATION_ACCEPTANCE);

        orderService.createOrder(jobVacancy, request.getTeacherId());
        return true;
    }

    public List<JobApplication> getJobApplicationsByStudent(BigInteger studentId) {
        List<JobVacancy> listJV = jobVacancyRepository.findAllByStudentIdAndMarkForDeleteFalse(studentId);
        List<JobApplication> listJA = new ArrayList<>();
        for(JobVacancy jv : listJV){
            listJA.addAll(jobApplicationRepository.findAllByJobVacancyIdAndMarkForDeleteFalse(jv.getId()));
        }

        return listJA;
    }
}

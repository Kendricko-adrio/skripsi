package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationId> {

  List<JobApplication> findAllByJobVacancyIdAndTeacherIdAndMarkForDeleteFalse(BigInteger jobVacancyId, BigInteger teacherId);

  List<JobApplication> findAllByJobVacancyIdAndMarkForDeleteFalse(BigInteger jobVacancyId);

  List<JobApplication> findAllByTeacherIdAndMarkForDeleteFalse(BigInteger teacherId);

  JobApplication findByJobVacancyIdAndTeacherId(BigInteger jobVacancyId, BigInteger teacherId);

}

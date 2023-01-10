package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationId> {

  List<JobApplication> findAllByJobVacancyIdAndTeacherIdAndMarkForDeleteFalse(BigInteger jobVacancyId, BigInteger teacherId);

  List<JobApplication> findAllByJobVacancyIdAndMarkForDeleteFalse(BigInteger jobVacancyId);

  List<JobApplication> findAllByTeacherIdAndMarkForDeleteFalse(BigInteger teacherId);

  Optional<JobApplication> findByJobVacancyIdAndTeacherId(BigInteger jobVacancyId, BigInteger teacherId);

}

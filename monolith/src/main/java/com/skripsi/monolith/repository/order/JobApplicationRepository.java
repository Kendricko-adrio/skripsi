package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationId> {

  List<JobApplication> findAllByJobVacancyIdAndTutorIdAndMarkForDeleteFalse(BigInteger jobVacancyId, BigInteger tutorId);

  List<JobApplication> findAllByJobVacancyIdAndMarkForDeleteFalse(BigInteger jobVacancyId);

  List<JobApplication> findAllByTutorIdAndMarkForDeleteFalse(BigInteger tutorId);

}

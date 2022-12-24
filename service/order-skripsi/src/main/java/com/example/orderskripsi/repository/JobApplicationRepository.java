package com.example.orderskripsi.repository;

import com.example.orderskripsi.model.JobApplication;
import com.example.orderskripsi.model.JobApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplication, JobApplicationId> {

  Optional<JobApplication> findByJobVacancyIdAndTeacherIdAndMarkForDeleteFalse(BigInteger jobVacancyId, BigInteger teacherId);

  List<JobApplication> findAllByJobVacancyIdAndTeacherIdAndMarkForDeleteFalse(BigInteger jobVacancyId, BigInteger teacherId);

  List<JobApplication> findAllByJobVacancyIdAndMarkForDeleteFalse(BigInteger jobVacancyId);

  List<JobApplication> findAllByTeacherIdAndMarkForDeleteFalse(BigInteger teacherId);

}

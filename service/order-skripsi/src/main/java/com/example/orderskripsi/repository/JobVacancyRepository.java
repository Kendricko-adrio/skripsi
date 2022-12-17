package com.example.orderskripsi.repository;

import com.example.orderskripsi.model.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface JobVacancyRepository extends JpaRepository<JobVacancy, BigInteger> {

  List<JobVacancy> findAllByStudentIdAndMarkForDeleteFalse(BigInteger studentId);

  List<JobVacancy> findAllByMarkForDeleteFalse();

}

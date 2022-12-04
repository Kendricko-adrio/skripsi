package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface JobVacancyRepository extends JpaRepository<JobVacancy, BigInteger> {

  List<JobVacancy> findAllByStudentIdAndMarkForDeleteFalse(BigInteger studentId);

  List<JobVacancy> findAllByMarkForDeleteFalse();

}

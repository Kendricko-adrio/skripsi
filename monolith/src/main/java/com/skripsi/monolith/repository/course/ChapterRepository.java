package com.skripsi.monolith.repository.course;

import com.skripsi.monolith.model.course.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, BigInteger> {

  List<Chapter> findAllByCourse_Id(BigInteger courseId);

}

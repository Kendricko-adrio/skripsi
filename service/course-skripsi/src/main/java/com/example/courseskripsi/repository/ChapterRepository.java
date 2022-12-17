package com.example.courseskripsi.repository;

import com.example.courseskripsi.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, BigInteger> {

  List<Chapter> findAllByCourse_Id(BigInteger courseId);

}

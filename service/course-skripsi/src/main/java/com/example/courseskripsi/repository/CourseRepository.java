package com.example.courseskripsi.repository;

import com.example.courseskripsi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepository extends JpaRepository<Course, BigInteger> {

}

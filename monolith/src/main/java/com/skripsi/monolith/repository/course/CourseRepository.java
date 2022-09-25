package com.skripsi.monolith.repository.course;

import com.skripsi.monolith.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepository extends JpaRepository<Course, BigInteger> {

}

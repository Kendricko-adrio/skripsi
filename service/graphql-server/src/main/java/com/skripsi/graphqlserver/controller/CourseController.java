package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.course.CourseClient;
import com.skripsi.graphqlserver.model.course.Chapter;
import com.skripsi.graphqlserver.model.course.Course;
import com.skripsi.graphqlserver.model.order.JobVacancy;
import com.skripsi.graphqlserver.model.order.Order;
import com.skripsi.graphqlserver.model.request.course.CourseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class CourseController {

  @Autowired
  private CourseClient courseClient;

  @QueryMapping
  public List<Course> getCourses() {
    return courseClient.getCourses().getData();
  }

  @QueryMapping
  public Course getCourse(@Argument BigInteger id) {
    return courseClient.getCourse(id).getData();
  }

  @MutationMapping
  public Course insertCourse(@Argument CourseInput input) {
    return courseClient.insertCourse(input).getData();
  }

  @MutationMapping
  public Course updateCourse(@Argument CourseInput input) {
    return courseClient.updateCourse(input).getData();
  }

  @SchemaMapping
  public Course course(Order order) {
    return courseClient.getCourse(order.getCourseId()).getData();
  }

  @SchemaMapping
  public Course course(JobVacancy jobVacancy) {
    return courseClient.getCourse(jobVacancy.getCourseId()).getData();
  }

}

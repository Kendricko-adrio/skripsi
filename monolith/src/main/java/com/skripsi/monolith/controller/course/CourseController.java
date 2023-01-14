package com.skripsi.monolith.controller.course;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.course.CourseService;
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
    private CourseService courseService;

    @QueryMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @QueryMapping
    public Course getCourse(@Argument BigInteger id){
        return courseService.getCourse(id);
    }

    @MutationMapping
    public Course insertCourse(@Argument CourseInput input){
        return courseService.insertCourse(input);
    }

    @MutationMapping
    public Course updateCourse(@Argument CourseInput input){
        return courseService.updateCourse(input);
    }

    @SchemaMapping
    public Course course(Order order){
        return courseService.getCourse(order.getCourse().getId());
    }

    @SchemaMapping
    public Course course(JobVacancy jobVacancy){
        return courseService.getCourse(jobVacancy.getCourse().getId());
    }
}

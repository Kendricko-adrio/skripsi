package com.skripsi.monolith.controller.course;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.course.CourseService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @MutationMapping
    public Course insertCourse(@Argument CourseInput input){
        return courseService.insertCourse(input);
    }

    @QueryMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @QueryMapping
    public Course getCourse(@Argument BigInteger id){
        return courseService.getCourse(id);
    }

    @MutationMapping
    public Course updateCourse(@Argument CourseInput input){
        return courseService.updateCourse(input);
    }

//    @SchemaMapping
//    public Course course(Order order){
//        return courseService.getCourse(order.getCourseId());
//    }
}

package com.federated.courses.dgs;

import com.federated.courses.dto.course.CourseInput;
import com.federated.courses.model.Course;
import com.federated.courses.model.order.JobVacancy;
import com.federated.courses.model.order.Order;
import com.federated.courses.service.CourseService;
import com.netflix.graphql.dgs.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

@DgsComponent
@Slf4j
public class CourseDataFetcher {

    @Autowired
    private CourseService courseService;

    @DgsQuery
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @DgsQuery
    public Course getCourse(@InputArgument String id){
        return courseService.getCourse(new BigInteger(id));
    }

    @DgsMutation
    public Course insertCourse(@InputArgument CourseInput input){
        return courseService.insertCourse(input);
    }

    @DgsMutation
    public Course updateCourse(@InputArgument CourseInput input){
        return courseService.updateCourse(input);
    }

    @DgsData(parentType = "Order", field = "course")
    public Course courseOrder(DgsDataFetchingEnvironment dfe){
        Order order = dfe.getSource();
        return courseService.getCourse(order.getCourse().getId());
    }

    @DgsData(parentType = "JobVacancy", field = "course")
    public Course courseJobVacancy(DgsDataFetchingEnvironment dfe) {
        JobVacancy jobVacancy = dfe.getSource();
        return courseService.getCourse(jobVacancy.getCourseId());
    }

}

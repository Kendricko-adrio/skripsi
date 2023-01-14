package com.federated.courses.dgs;

import com.federated.courses.dto.course.CourseInput;
import com.federated.courses.model.Chapter;
import com.federated.courses.model.Course;
import com.federated.courses.model.order.JobVacancy;
import com.federated.courses.model.order.Order;
import com.federated.courses.service.CourseService;
import com.netflix.graphql.dgs.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;

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
    public Course insertCourse(@Argument CourseInput input){
        return courseService.insertCourse(input);
    }

    @DgsMutation
    public Course updateCourse(@Argument CourseInput input){
        return courseService.updateCourse(input);
    }

//    @SchemaMapping
//    public Course course(Order order){
//
//        return courseService.getCourse(order.getCourse().getId());
//    }

//    @SchemaMapping
//    public Course course(JobVacancy jobVacancy){
//        return courseService.getCourse(jobVacancy.getCourse().getId());
//    }
    @DgsData(parentType = "JobVacancy", field = "course")
    public Course courseJobVacancy(DgsDataFetchingEnvironment dfe){
        JobVacancy jobVacancy = dfe.getSource();
        return courseService.getCourse(jobVacancy.getCourseId());
    }

}

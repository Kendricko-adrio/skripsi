package com.skripsi.monolith.service.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.repository.course.CourseRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course insertCourse(@Argument CourseInput input){
        Course course = requestToCourseMapper(input);
        return repository.save(course);
    }

    public List<Course> getCourses(){
        return repository.findAll();
    }

    public Course getCourse(BigInteger id){
        Optional<Course> course = repository.findById(id);
        if(!course.isPresent()){
            throw new RuntimeException("No course found!");
        }
        return course.get();
    }

    public Course updateCourse(@Argument CourseInput input){
        Optional<Course> course = repository.findById(input.getId());
        if(!course.isPresent()){
            throw new RuntimeException("No course found!");
        }
        Course courseUpdate = course.get();
        courseUpdate.setCourseName(input.getCourseName());
        courseUpdate.setCourseDescription(input.getCourseDescription());
        courseUpdate.setCreatedBy(input.getCreatedBy());
        return repository.save(courseUpdate);
    }

    private Course requestToCourseMapper(CourseInput courseInput){
        return Course.builder()
            .courseName(courseInput.getCourseName())
            .courseDescription(courseInput.getCourseDescription())
            .coursePrice(courseInput.getCoursePrice())
            .createdBy(courseInput.getCreatedBy())
            .build();
    }

}

package com.example.courseskripsi.service;

import com.example.courseskripsi.dto.CourseInput;
import com.example.courseskripsi.model.Course;
import com.example.courseskripsi.repository.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public Course insertCourse(CourseInput input){
        ObjectMapper mapper = new ObjectMapper();
        Course course = mapper.convertValue(input, Course.class);
        return repository.save(course);
    }

    public Course updateCourse(CourseInput input){
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

}

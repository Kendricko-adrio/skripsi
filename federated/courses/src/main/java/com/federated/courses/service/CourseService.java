package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.dto.course.CourseInput;
import com.federated.courses.dto.course.CourseRequest;
import com.federated.courses.model.Course;
import com.federated.courses.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CourseService extends ExternalBaseService{


    @Value("${external.course.url}")
    String courseUrl;
    private ObjectMapper mapper = new ObjectMapper();

    public Course insertCourse(CourseInput input){
        CourseRequest courseRequest = inputToRequest(input);
        Response response = hitExternalService(courseUrl, HttpMethod.POST, courseRequest, null, Response.class);
        return mapper.convertValue(response.getData(), Course.class);
    }

    public List<Course> getCourses(){
        Response response = hitExternalService(courseUrl, HttpMethod.GET, null, null,Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Course.class));
    }

    public Course getCourse(BigInteger id){
        Response response = hitExternalService(courseUrl + "/" + id, HttpMethod.GET, null, null,Response.class);
        return mapper.convertValue(response.getData(), Course.class);
    }

    public Course updateCourse(CourseInput input){
        CourseRequest courseRequest = inputToRequest(input);
        Response response = hitExternalService(courseUrl, HttpMethod.PUT, courseRequest, null, Response.class);
        return mapper.convertValue(response.getData(), Course.class);
    }

    private CourseRequest inputToRequest(CourseInput input){
        return CourseRequest.builder()
                .id(input.getId() == null ? null : new BigInteger(input.getId()))
                .courseName(input.getCourseName())
                .courseDescription(input.getCourseDescription())
                .coursePrice(BigInteger.valueOf(input.getCoursePrice()))
                .createdBy(BigInteger.valueOf(input.getCreatedBy()))
                .build();
    }

}

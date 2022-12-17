package com.skripsi.graphqlserver.client.course;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.course.Course;
import com.skripsi.graphqlserver.model.request.course.CourseInput;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class CourseClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;


  public CourseClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Course>> getCourses() {
    return restTemplate.exchange(serviceProperties.getCourse() + "course",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<List<Course>>>() {
        }).getBody();
  }

  public Response<Course> getCourse(BigInteger id) {
    return restTemplate.exchange(serviceProperties.getCourse() + "course/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<Course>>() {
        }).getBody();
  }

  public Response<Course> insertCourse(CourseInput request) {
    HttpEntity<CourseInput> entity = new HttpEntity<>(request);
    return restTemplate.exchange(serviceProperties.getCourse() + "course",
        HttpMethod.POST,
        entity,
        new ParameterizedTypeReference<Response<Course>>() {
        }).getBody();
  }

  public Response<Course> updateCourse(CourseInput request) {
    HttpEntity<CourseInput> entity = new HttpEntity<>(request);
    return restTemplate.exchange(serviceProperties.getCourse() + "course",
        HttpMethod.PUT,
        entity,
        new ParameterizedTypeReference<Response<Course>>() {
        }).getBody();
  }

}

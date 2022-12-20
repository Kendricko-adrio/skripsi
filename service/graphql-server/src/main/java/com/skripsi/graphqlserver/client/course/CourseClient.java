package com.skripsi.graphqlserver.client.course;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.course.Course;
import com.skripsi.graphqlserver.model.request.course.CourseInput;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import lombok.Getter;
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

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getCourse();
  }

  public CourseClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Course>> getCourses() {
    return get("course", new ParameterizedTypeReference<Response<List<Course>>>() {});
  }

  public Response<Course> getCourse(BigInteger id) {
    return get("course/" + id, new ParameterizedTypeReference<Response<Course>>() {});
  }

  public Response<Course> insertCourse(CourseInput request) {
    return post("course", request, new ParameterizedTypeReference<Response<Course>>() {});
  }

  public Response<Course> updateCourse(CourseInput request) {
    return put("course", request, new ParameterizedTypeReference<Response<Course>>() {});
  }

}

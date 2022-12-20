package com.skripsi.graphqlserver.client.course;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.course.Chapter;
import com.skripsi.graphqlserver.model.request.course.CreateChapterRequest;
import com.skripsi.graphqlserver.model.request.course.UpdateChapterRequest;
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
public class ChapterClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getCourse();
  }

  public ChapterClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Chapter>> getChapters() {
    return get("chapter", new ParameterizedTypeReference<Response<List<Chapter>>>() {
    });
  }

  public Response<Chapter> getChapter(BigInteger id) {
    return get("chapter/" + id, new ParameterizedTypeReference<Response<Chapter>>() {
    });
  }

  public Response<Chapter> insertChapter(CreateChapterRequest request) {
    return post("chapter", request, new ParameterizedTypeReference<Response<Chapter>>() {
    });
  }

  public Response<Chapter> updateChapter(UpdateChapterRequest request) {
    return put("chapter", request, new ParameterizedTypeReference<Response<Chapter>>() {
    });
  }
}

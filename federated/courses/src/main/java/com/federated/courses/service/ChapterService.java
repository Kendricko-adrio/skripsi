package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.dto.course.CreateChapter;
import com.federated.courses.dto.course.CreateChapterRequest;
import com.federated.courses.dto.course.UpdateChapter;
import com.federated.courses.dto.course.UpdateChapterRequest;
import com.federated.courses.model.Chapter;
import com.federated.courses.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ChapterService extends ExternalBaseService {

  @Value("${external.chapter.url}")
  private String chapterUrl;

  private ObjectMapper mapper = new ObjectMapper();

  public List<Chapter> getChapters() {
    Response response = hitExternalService(chapterUrl, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Chapter.class));
  }

  public Chapter getChapter(BigInteger id) {
    Response response = hitExternalService(chapterUrl + "/" + id, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), Chapter.class);
  }

  public List<Chapter> getChaptersByCourse(BigInteger courseId) {
    Response response = hitExternalService(chapterUrl + "/course/" + courseId, HttpMethod.GET, null, null, Response.class);
    return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Chapter.class));
  }

  public Chapter insertChapter(CreateChapter request) {
    Response response = hitExternalService(chapterUrl, HttpMethod.POST,inputToRequest(request) , null, Response.class);
    return mapper.convertValue(response.getData(), Chapter.class);
  }

  public Chapter updateChapter(UpdateChapter request) {
    Response response = hitExternalService(chapterUrl, HttpMethod.PUT,inputToRequest(request), null, Response.class);
    return mapper.convertValue(response.getData(), Chapter.class);
  }

  private CreateChapterRequest inputToRequest(CreateChapter request) {
    return CreateChapterRequest.builder()
            .courseId(new BigInteger(request.getCourseId()))
            .detail(request.getDetail())
            .name(request.getName())
            .build();
  }

  private UpdateChapterRequest inputToRequest(UpdateChapter request){
    return UpdateChapterRequest.builder()
            .id(new BigInteger(request.getId()))
            .detail(request.getDetail())
            .name(request.getName())
            .build();
  }

//  public Boolean deleteChapter(BigInteger id) {
//    return true;
//  }
//
//  public List<Chapter> getChaptersByCourse(BigInteger courseId) {
//    return null;
//  }

}

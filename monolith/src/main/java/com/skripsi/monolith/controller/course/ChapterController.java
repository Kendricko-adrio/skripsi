package com.skripsi.monolith.controller.course;

import com.skripsi.monolith.dto.course.CreateChapterRequest;
import com.skripsi.monolith.dto.course.UpdateChapterRequest;
import com.skripsi.monolith.model.course.Chapter;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.service.course.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class ChapterController {

  @Autowired
  private ChapterService chapterService;

  @QueryMapping
  public Chapter getChapter(BigInteger id) {
    return chapterService.getChapter(id);
  }

  @QueryMapping
  public List<Chapter> getChapters() {
    return chapterService.getChapters();
  }

  @MutationMapping
  public Chapter createChapter(CreateChapterRequest request) {
    return chapterService.insertChapter(request);
  }

  @MutationMapping
  public Chapter updateChapter(UpdateChapterRequest request) {
    return chapterService.updateChapter(request);
  }

  @SchemaMapping
  public List<Chapter> chapters(Course course) {
    return chapterService.getChaptersByCourse(course.getId());
  }

}

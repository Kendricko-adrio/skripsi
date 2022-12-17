package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.course.ChapterClient;
import com.skripsi.graphqlserver.model.course.Chapter;
import com.skripsi.graphqlserver.model.request.course.CreateChapterRequest;
import com.skripsi.graphqlserver.model.request.course.UpdateChapterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class ChapterController {

  @Autowired
  private ChapterClient chapterClient;

  @QueryMapping
  public List<Chapter> getChapters() {
    return chapterClient.getChapters().getData();
  }

  @QueryMapping
  public Chapter getChapter(BigInteger id) {
    return chapterClient.getChapter(id).getData();
  }

  @MutationMapping
  public Chapter createChapter(CreateChapterRequest chapter) {
    return chapterClient.insertChapter(chapter).getData();
  }

  @MutationMapping
  public Chapter updateChapter(UpdateChapterRequest chapter) {
    return chapterClient.updateChapter(chapter).getData();
  }

}

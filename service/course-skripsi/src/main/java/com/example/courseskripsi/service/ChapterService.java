package com.example.courseskripsi.service;

import com.example.courseskripsi.dto.CreateChapterRequest;
import com.example.courseskripsi.dto.UpdateChapterRequest;
import com.example.courseskripsi.model.Chapter;
import com.example.courseskripsi.repository.ChapterRepository;
import com.example.courseskripsi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ChapterService {

  @Autowired
  private ChapterRepository chapterRepository;

  @Autowired
  private CourseRepository courseRepository;

  public List<Chapter> getChapters() {
    return chapterRepository.findAll();
  }

  public Chapter getChapter(BigInteger id) {
    return chapterRepository.findById(id).orElse(null);
  }

  public Chapter insertChapter(CreateChapterRequest request) {
    Chapter chapter = Chapter.builder()
        .name(request.getName())
        .detail(request.getDetail())
        .course(courseRepository.findById(request.getCourseId()).orElse(null))
        .build();

    return chapterRepository.save(chapter);
  }

  public Chapter updateChapter(UpdateChapterRequest request) {
    Chapter chapter = chapterRepository.findById(request.getId()).get();
    chapter.setName(request.getName());
    chapter.setDetail(request.getDetail());
    return chapterRepository.save(chapter);
  }

  public Boolean deleteChapter(BigInteger id) {
    Chapter chapter = chapterRepository.findById(id).get();
    chapterRepository.delete(chapter);
    return true;
  }

  public List<Chapter> getChaptersByCourse(BigInteger courseId) {
    return chapterRepository.findAllByCourse_Id(courseId);
  }

}

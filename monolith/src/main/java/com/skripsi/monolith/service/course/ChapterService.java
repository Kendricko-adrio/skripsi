package com.skripsi.monolith.service.course;

import com.skripsi.monolith.dto.course.CreateChapterRequest;
import com.skripsi.monolith.dto.course.UpdateChapterRequest;
import com.skripsi.monolith.model.course.Chapter;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.repository.course.ChapterRepository;
import com.skripsi.monolith.repository.course.CourseRepository;
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

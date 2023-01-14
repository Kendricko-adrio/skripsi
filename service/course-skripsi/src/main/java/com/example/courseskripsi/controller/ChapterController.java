package com.example.courseskripsi.controller;

import com.example.courseskripsi.constant.ResponseMessage;
import com.example.courseskripsi.dto.BaseResponse;
import com.example.courseskripsi.dto.CreateChapterRequest;
import com.example.courseskripsi.dto.UpdateChapterRequest;
import com.example.courseskripsi.model.Chapter;
import com.example.courseskripsi.model.Course;
import com.example.courseskripsi.service.ChapterService;
import com.example.courseskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getChapter(@PathVariable BigInteger id) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, chapterService.getChapter(id));
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getChapters() {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, chapterService.getChapters());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<BaseResponse> getChaptersByCourse(@PathVariable BigInteger id) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, chapterService.getChaptersByCourse(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createChapter(@RequestBody CreateChapterRequest request) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, chapterService.insertChapter(request));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> updateChapter(@RequestBody UpdateChapterRequest request) {
        return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, chapterService.updateChapter(request));
    }

}

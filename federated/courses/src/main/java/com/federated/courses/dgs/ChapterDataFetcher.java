package com.federated.courses.dgs;

import com.federated.courses.dto.course.CreateChapter;
import com.federated.courses.dto.course.UpdateChapter;
import com.federated.courses.model.Chapter;
import com.federated.courses.service.ChapterService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

@DgsComponent
public class ChapterDataFetcher {

    @Autowired
    private ChapterService chapterService;

    @DgsQuery
    public Chapter getChapter(@InputArgument String id) {
        return chapterService.getChapter(new BigInteger(id));
    }

    @DgsQuery
    public List<Chapter> getChapters() {
        return chapterService.getChapters();
    }

    @DgsMutation
    public Chapter createChapter(@InputArgument CreateChapter input) {
        return chapterService.insertChapter(input);
    }

    @DgsMutation
    public Chapter updateChapter(@InputArgument UpdateChapter input) {
        return chapterService.updateChapter(input);
    }

//    @SchemaMapping
//    public List<Chapter> chapters(Course course) {
//        return chapterService.getChaptersByCourse(course.getId());
//    }

}

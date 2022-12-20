package com.skripsi.graphqlserver.model.request.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class CourseInput {
    private BigInteger id;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_description")
    private String courseDescription;

    @JsonProperty("course_price")
    private BigInteger coursePrice;

    @JsonProperty("created_by")
    private BigInteger createdBy;
}

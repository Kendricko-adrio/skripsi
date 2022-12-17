package com.federated.courses.dto.course;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CourseInput {
    private String id;
    private String courseName;
    private String courseDescription;
    private Integer coursePrice;
    private Integer createdBy;
}

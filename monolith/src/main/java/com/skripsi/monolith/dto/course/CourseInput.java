package com.skripsi.monolith.dto.course;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CourseInput {
    private BigInteger id;
    private String courseName;
    private String courseDescription;
    private BigInteger coursePrice;
    private BigInteger createdBy;
}

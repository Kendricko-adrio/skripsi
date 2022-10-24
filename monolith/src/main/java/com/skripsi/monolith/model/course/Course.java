package com.skripsi.monolith.model.course;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private BigInteger id;
    private String courseName;
    private String courseDescription;
    private BigInteger createdBy;
}

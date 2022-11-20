package com.skripsi.monolith.model.course;

import com.skripsi.monolith.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "courses")
@Data
public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private BigInteger id;

    private String courseName;

    private String courseDescription;

    private BigInteger coursePrice;

    private BigInteger createdBy;
}

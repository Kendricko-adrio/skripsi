package com.federated.courses.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
    private BigInteger id;

    private String courseName;

    private String courseDescription;

    private BigInteger coursePrice;

    private User createdBy;
}

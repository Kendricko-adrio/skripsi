package com.skripsi.graphqlserver.model.order;

import com.skripsi.graphqlserver.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobVacancy extends BaseEntity {

  private BigInteger id;

  private Boolean isActive;

  private BigInteger studentId;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "student_id")
//  private User student;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "course_id")
//  private Course course;

  private BigInteger courseId;

  private String description;

  private boolean markForDelete;
}

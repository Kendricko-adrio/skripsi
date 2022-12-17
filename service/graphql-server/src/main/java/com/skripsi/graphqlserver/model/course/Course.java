package com.skripsi.graphqlserver.model.course;

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
public class Course extends BaseEntity {
  private BigInteger id;

  private String courseName;

  private String courseDescription;

  private BigInteger coursePrice;

  private BigInteger createdBy;

}
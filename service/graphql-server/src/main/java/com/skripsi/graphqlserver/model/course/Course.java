package com.skripsi.graphqlserver.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
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

  @JsonProperty("course_name")
  private String courseName;

  @JsonProperty("course_description")
  private String courseDescription;

  @JsonProperty("course_price")
  private BigInteger coursePrice;

  @JsonProperty("created_by")
  private BigInteger createdBy;

}
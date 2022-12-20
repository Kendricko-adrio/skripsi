package com.federated.courses.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.federated.courses.model.User;
import com.federated.courses.model.BaseEntity;
import com.federated.courses.model.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobVacancy extends BaseEntity {

  private BigInteger id;

  private Boolean isActive;

  @JsonProperty("student_id")
  private User student;

  private BigInteger courseId;
  private Course course;

  private String description;

  private JobApplication jobApplication;

  private boolean markForDelete;
}

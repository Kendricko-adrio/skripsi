package com.federated.courses.dto.jobvacancy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobVacancyRequest {

  private String courseId;

  private String studentId;

  private String description;

}

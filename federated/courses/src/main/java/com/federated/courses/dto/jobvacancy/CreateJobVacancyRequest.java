package com.federated.courses.dto.jobvacancy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobVacancyRequest {

  @NotBlank(message = "NotBlank")
  private String courseId;

  @NotBlank(message = "NotBlank")
  private String studentId;

  @NotBlank(message = "NotBlank")
  private String description;

}

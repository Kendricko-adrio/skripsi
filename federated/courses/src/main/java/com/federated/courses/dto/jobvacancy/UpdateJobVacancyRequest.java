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
public class UpdateJobVacancyRequest {

  @NotBlank(message = "NotBlank")
  private String id;

  @NotBlank(message = "NotBlank")
  private String description;

  @NotBlank(message = "NotBlank")
  private Boolean isActive;

}
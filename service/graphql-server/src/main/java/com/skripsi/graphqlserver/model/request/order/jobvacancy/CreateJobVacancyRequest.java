package com.skripsi.graphqlserver.model.request.order.jobvacancy;

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
  private BigInteger courseId;

  @NotBlank(message = "NotBlank")
  private BigInteger studentId;

  @NotBlank(message = "NotBlank")
  private String description;

}

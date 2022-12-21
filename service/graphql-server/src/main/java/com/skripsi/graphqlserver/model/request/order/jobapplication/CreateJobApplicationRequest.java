package com.skripsi.graphqlserver.model.request.order.jobapplication;

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
public class CreateJobApplicationRequest {

  @NotBlank(message = "NotBlank")
  private BigInteger jobVacancyId;

  @NotBlank(message = "NotBlank")
  private BigInteger teacherId;

}

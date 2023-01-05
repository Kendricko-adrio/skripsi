package com.federated.courses.dto.jobapplication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcceptJobApplicationRequest {

  @NotNull(message = "NotNull")
  private String jobVacancyId;

  @NotNull(message = "NotNull")
  private String teacherId;

}

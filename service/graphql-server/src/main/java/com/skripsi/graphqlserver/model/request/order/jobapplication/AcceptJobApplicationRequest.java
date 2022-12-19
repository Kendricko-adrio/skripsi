package com.skripsi.graphqlserver.model.request.order.jobapplication;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty("job_vacancy_id")
  private BigInteger jobVacancyId;

  @NotNull(message = "NotNull")
  @JsonProperty("teacher_id")
  private BigInteger teacherId;

}

package com.example.orderskripsi.dto.jobapplication;

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
public class RejectJobApplicationRequest {

  @NotNull(message = "NotNull")
  private BigInteger jobVacancyId;

  @NotNull(message = "NotNull")
  private BigInteger teacherId;

}

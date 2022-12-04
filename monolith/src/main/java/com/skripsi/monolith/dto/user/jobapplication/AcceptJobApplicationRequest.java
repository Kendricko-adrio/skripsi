package com.skripsi.monolith.dto.user.jobapplication;

import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
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
  private BigInteger jobVacancyId;

  @NotNull(message = "NotNull")
  private BigInteger teacherId;

}

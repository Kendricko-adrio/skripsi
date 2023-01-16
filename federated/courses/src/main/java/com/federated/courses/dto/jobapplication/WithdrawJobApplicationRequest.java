package com.federated.courses.dto.jobapplication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawJobApplicationRequest {

  private String jobVacancyId;

  private String teacherId;

}

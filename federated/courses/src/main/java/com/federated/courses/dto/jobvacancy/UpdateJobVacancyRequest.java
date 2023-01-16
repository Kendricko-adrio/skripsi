package com.federated.courses.dto.jobvacancy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJobVacancyRequest {

  private String id;

  private String description;

  private Boolean isActive;

}
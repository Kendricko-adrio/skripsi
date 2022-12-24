package com.skripsi.graphqlserver.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skripsi.graphqlserver.constant.JobApplicationStatus;
import com.skripsi.graphqlserver.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication extends BaseEntity {

  @JsonProperty("job_vacancy_id")
  private BigInteger jobVacancyId;

  @JsonProperty("teacher_id")
  private BigInteger teacherId;

  @JsonProperty("approval_status")
  private JobApplicationStatus approvalStatus;

  @JsonProperty("mark_for_delete")
  private boolean markForDelete;
}

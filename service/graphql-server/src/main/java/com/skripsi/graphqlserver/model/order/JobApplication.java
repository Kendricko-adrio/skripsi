package com.skripsi.graphqlserver.model.order;

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

  private BigInteger jobVacancyId;

  private BigInteger teacherId;

  private JobApplicationStatus approvalStatus;

  private boolean markForDelete;
}

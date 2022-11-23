package com.skripsi.monolith.model.order;

import com.skripsi.monolith.model.BaseEntity;
import com.skripsi.monolith.model.constants.JobApplicationStatus;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "job_applications")
@IdClass(JobApplicationId.class)
public class JobApplication extends BaseEntity {

  @Id
  @Column(name = "job_vacancy_id")
  private BigInteger jobVacancyId;

  @Id
  @Column(name = "tutor_id")
  private BigInteger tutorId;

  @Column(name = "approval_status")
  @Enumerated(EnumType.STRING)
  private JobApplicationStatus approvalStatus;

  @Column(name = "mark_for_delete")
  private boolean markForDelete;
}

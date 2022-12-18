package com.skripsi.monolith.model.order;

import com.skripsi.monolith.model.BaseEntity;
import com.skripsi.monolith.model.constants.JobApplicationStatus;
import com.skripsi.monolith.model.order.jobapplication.JobApplicationId;
import com.skripsi.monolith.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
  @Column(name = "teacher_id")
  private BigInteger teacherId;

  @Column(name = "approval_status")
  @Enumerated(EnumType.STRING)
  private JobApplicationStatus approvalStatus;

  @Column(name = "mark_for_delete")
  private boolean markForDelete;


}

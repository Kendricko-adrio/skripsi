package com.skripsi.monolith.model.order.jobapplication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class JobApplicationId implements Serializable {

  private static final long serialVersionUID = 8022146861808119979L;

  private BigInteger jobVacancyId;

  private BigInteger teacherId;
}

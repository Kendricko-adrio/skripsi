package com.skripsi.monolith.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum JobApplicationStatus {

  PENDING("Pending"),
  APPROVED("Approved"),
  REJECTED_BY_STUDENT("Rejected by Student"),
  CANCELLED_BY_TUTOR("Cancelled by Tutor");

  @Getter
  private String description;
}

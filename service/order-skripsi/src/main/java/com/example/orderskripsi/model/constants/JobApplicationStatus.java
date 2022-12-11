package com.example.orderskripsi.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum JobApplicationStatus {

  PENDING("Pending"),
  APPROVED("Approved"),
  REJECTED_BY_STUDENT("Rejected by Student"),
  CANCELLED_BY_TEACHER("Cancelled by Teacher");

  @Getter
  private String description;
}

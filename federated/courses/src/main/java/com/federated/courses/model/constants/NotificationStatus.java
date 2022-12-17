package com.federated.courses.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationStatus {

  JOB_APPLICATION_NEW("You have a new job application"),
  JOB_APPLICATION_WITHDRAW("Your job application has been withdrawn"),
  JOB_APPLICATION_REJECTION("Your Job Application Has been Rejected"),
  JOB_APPLICATION_ACCEPTANCE("Your Job Application Has been Accepted");

  @Getter
  private final String desc;
}

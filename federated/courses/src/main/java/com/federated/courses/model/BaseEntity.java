package com.federated.courses.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;


@Data
@JsonNaming(value = com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BaseEntity implements Serializable {

  protected long createdAt;

  protected long updatedAt;

}

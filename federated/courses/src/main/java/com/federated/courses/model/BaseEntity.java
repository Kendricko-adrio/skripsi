package com.federated.courses.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

  @CreatedDate
  protected long createdAt;

  @LastModifiedDate
  protected long updatedAt;

}

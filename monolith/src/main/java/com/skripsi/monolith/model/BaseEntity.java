package com.skripsi.monolith.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

  @CreatedDate
  private long createdAt;

  @LastModifiedDate
  private long updatedAt;

}

package com.skripsi.graphqlserver.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

  protected long createdAt;

  protected long updatedAt;

}


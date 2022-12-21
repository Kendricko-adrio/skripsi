package com.skripsi.graphqlserver.model.course;

import com.skripsi.graphqlserver.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chapter extends BaseEntity {

  private BigInteger id;

  private String name;

  private String detail;

  private Course course;

}

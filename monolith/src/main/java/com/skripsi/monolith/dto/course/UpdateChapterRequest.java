package com.skripsi.monolith.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateChapterRequest {

  private BigInteger id;

  private String name;

  private String detail;

}

package com.federated.courses.dto.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChapter {

  private String name;

  private String detail;

  @NotBlank(message = "NotBlank")
  private String courseId;

}

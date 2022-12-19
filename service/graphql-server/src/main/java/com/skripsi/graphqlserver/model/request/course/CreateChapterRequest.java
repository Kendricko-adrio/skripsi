package com.skripsi.graphqlserver.model.request.course;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CreateChapterRequest {

  private String name;

  private String detail;

  @JsonProperty("course_id")
  @NotBlank(message = "NotBlank")
  private BigInteger courseId;

}

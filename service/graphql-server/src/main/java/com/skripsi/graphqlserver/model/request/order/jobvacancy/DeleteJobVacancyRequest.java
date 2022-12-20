package com.skripsi.graphqlserver.model.request.order.jobvacancy;

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
public class DeleteJobVacancyRequest {

  @NotBlank(message = "NotBlank")
  private BigInteger id;

}

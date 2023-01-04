package com.federated.courses.dto.jobvacancy;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigInteger;


@Builder
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobVacancyExternalRequest {
    @NotBlank(message = "NotBlank")
    private BigInteger courseId;

    @NotBlank(message = "NotBlank")
    private BigInteger studentId;

    @NotBlank(message = "NotBlank")
    private String description;
}

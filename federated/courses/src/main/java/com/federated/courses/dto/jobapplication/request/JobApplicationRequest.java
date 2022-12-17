package com.federated.courses.dto.jobapplication.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobApplicationRequest {
    @NotNull(message = "NotNull")
    private BigInteger jobVacancyId;

    @NotNull(message = "NotNull")
    private BigInteger teacherId;
}

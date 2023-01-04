package com.federated.courses.dto.jobvacancy;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobVacancyUpdateRequest {

    private BigInteger id;

    private String description;

    private Boolean isActive;
}

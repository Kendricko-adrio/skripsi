package com.federated.courses.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.federated.courses.model.BaseEntity;
import com.federated.courses.model.User;
import com.federated.courses.model.constants.JobApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JobApplication extends BaseEntity {

    private BigInteger jobVacancyId;

    //  private BigInteger teacherId;
    @JsonProperty("teacher_id")
    private User teacher;

    private JobApplicationStatus approvalStatus;

    private boolean markForDelete;
}

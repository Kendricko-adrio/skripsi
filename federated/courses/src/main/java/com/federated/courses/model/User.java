package com.federated.courses.model;

import com.federated.courses.model.order.JobVacancy;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private BigInteger id;
//    private List<JobVacancy> jobVacancies;
}

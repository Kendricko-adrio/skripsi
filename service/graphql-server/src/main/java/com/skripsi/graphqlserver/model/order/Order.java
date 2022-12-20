package com.skripsi.graphqlserver.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Order extends BaseEntity {
    private BigInteger id;

    @JsonProperty("course_id")
    private BigInteger courseId;

    @JsonProperty("student_id")
    private BigInteger studentId;

    @JsonProperty("teacher_id")
    private BigInteger teacherId;

    @JsonProperty("is_active")
    private Boolean isActive;

}

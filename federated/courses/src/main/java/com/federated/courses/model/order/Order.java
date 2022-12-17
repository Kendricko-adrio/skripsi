package com.federated.courses.model.order;

import com.federated.courses.model.BaseEntity;
import com.federated.courses.model.Course;
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
public class Order extends BaseEntity {
    private BigInteger id;

    private Course course;

    private BigInteger studentId;

    private BigInteger teacherId;

    @Column(name = "is_active")
    private Boolean isActive;

}

package com.skripsi.graphqlserver.model.order;

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

    private BigInteger courseId;

    private BigInteger studentId;

    private BigInteger teacherId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")
//    private User student;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_id")
//    private User teacher;

    private Boolean isActive;

}

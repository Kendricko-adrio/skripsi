package com.skripsi.monolith.model.order;

import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.repository.course.CourseRepository;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger courseId;
    private BigInteger teacherId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "course_id")
    private Course course;
}

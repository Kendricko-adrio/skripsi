package com.skripsi.monolith.model.order;

import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.repository.course.CourseRepository;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    private User tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "mark_for_delete")
    private boolean markForDelete;
}

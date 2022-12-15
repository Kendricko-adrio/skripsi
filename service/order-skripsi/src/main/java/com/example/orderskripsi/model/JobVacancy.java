package com.example.orderskripsi.model;

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
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "job_vacancies")
public class JobVacancy extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "is_active")
  private Boolean isActive;

  private BigInteger studentId;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "student_id")
//  private User student;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "course_id")
//  private Course course;

  private BigInteger courseId;

  private String description;

  @Column(name = "mark_for_delete")
  private boolean markForDelete;
}

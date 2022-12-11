package com.example.orderskripsi.repository;

import com.example.orderskripsi.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    List<Order> findByIsActive(Boolean isActive);

//    List<Order> findByTeacherId(BigInteger id, Pageable pageable);
//
//    @Query(value = "select o from Order o where o.course.createdBy = :id")
//    List<Order> findByStudentId(BigInteger id, Pageable pageable);
    @Query(value = "select o from Order o where o.studentId = :id OR o.teacherId = :id")
    List<Order> viewOrderedJob(BigInteger id, Pageable pageable);
}

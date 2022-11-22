package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    public List<Order> findByIsActive(Boolean isActive);

    public List<Order> findByTeacherId(BigInteger id, Pageable pageable);

    @Query(value = "select o from Order o where o.course.createdBy = :id")
    public List<Order> findByStudentId(BigInteger id, Pageable pageable);
}

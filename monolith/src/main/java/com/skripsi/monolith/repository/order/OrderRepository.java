package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    List<Order> findByIsActive(Boolean isActive);

    @Query(value = "select o from Order o where o.student = :id OR o.teacher = :id")
    List<Order> viewOrderedJob(BigInteger id, Pageable pageable);
}

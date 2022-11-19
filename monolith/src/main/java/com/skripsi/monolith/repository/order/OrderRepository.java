package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    public List<Order> findByIsActive(Boolean isActive);
}

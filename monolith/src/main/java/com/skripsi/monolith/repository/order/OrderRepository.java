package com.skripsi.monolith.repository.order;

import com.skripsi.monolith.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

}

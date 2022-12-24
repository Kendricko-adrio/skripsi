package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.order.OrderClient;
import com.skripsi.graphqlserver.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class OrderController {

  @Autowired
  private OrderClient orderClient;

  @QueryMapping
  public List<Order> getAllOrder() {
    return orderClient.getAllOrder().getData();
  }

  @QueryMapping
  public List<Order> viewOwnOrder(@Argument Integer page,
      @Argument Integer size,
      @Argument BigInteger userId) {
    return orderClient.viewOwnOrder(page, size, userId).getData();
  }

}

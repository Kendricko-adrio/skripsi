package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.order.OrderClient;
import com.skripsi.graphqlserver.model.order.Order;
import com.skripsi.graphqlserver.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

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
  public List<Order> viewOwnOrder(@RequestParam Integer page,
      @RequestParam Integer size,
      @RequestParam BigInteger userId) {
    return orderClient.viewOwnOrder(page, size, userId).getData();
  }

}

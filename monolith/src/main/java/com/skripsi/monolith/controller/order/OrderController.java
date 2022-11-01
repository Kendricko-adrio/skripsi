package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.order.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(@Argument CourseInput courseInput){
        return orderService.createOrder(courseInput);
    }
}

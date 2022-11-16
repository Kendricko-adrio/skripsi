package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.dto.order.OrderInput;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.order.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

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

    @MutationMapping
    public Order deleteOrder(@Argument BigInteger orderId){
        return orderService.deleteOrder(orderId);
    }

    @MutationMapping
    public Order assignTeacher(@Argument OrderInput orderInput){
        return orderService.assignTeacher(orderInput);
    }
    @QueryMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }
}

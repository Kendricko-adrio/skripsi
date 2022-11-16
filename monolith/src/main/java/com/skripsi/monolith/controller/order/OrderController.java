package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.dto.order.OrderInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.course.CourseService;
import com.skripsi.monolith.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CourseService courseService;

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
    public Order cancelJobApplication(@Argument OrderInput orderInput){
        return orderService.cancelJobApplication(orderInput);
    }

    @MutationMapping
    public Order assignTeacher(@Argument OrderInput orderInput){
        return orderService.assignTeacher(orderInput);
    }
    @QueryMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
      
    @SchemaMapping
    public Course course(Order order) {
        return courseService.getCourse(order.getCourse().getId());
    }
}

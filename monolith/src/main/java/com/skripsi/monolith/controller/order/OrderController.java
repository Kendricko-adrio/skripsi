package com.skripsi.monolith.controller.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.service.course.CourseService;
import com.skripsi.monolith.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

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

    @SchemaMapping
    public Course course(Order order) {
        return courseService.getCourse(order.getCourse().getId());
    }
}

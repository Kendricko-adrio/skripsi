package com.skripsi.monolith.service.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.repository.order.OrderRepository;
import com.skripsi.monolith.service.course.CourseService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CourseService courseService;

    public OrderService(OrderRepository orderRepository, CourseService courseService) {
        this.orderRepository = orderRepository;
        this.courseService = courseService;
    }

    public Order getOrder(BigInteger id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(CourseInput courseInput) {
        Course course = courseService.insertCourse(courseInput);
        Order order = new Order();
        order.setCourse(course);
        return orderRepository.save(order);
    }

}

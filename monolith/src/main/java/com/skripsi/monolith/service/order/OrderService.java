package com.skripsi.monolith.service.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.dto.order.OrderInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.model.user.Role;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.repository.order.OrderRepository;
import com.skripsi.monolith.repository.user.UserRepository;
import com.skripsi.monolith.service.course.CourseService;
import com.skripsi.monolith.service.user.RoleService;
import com.skripsi.monolith.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private CourseService courseService;
    private RoleService roleService;
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, CourseService courseService, RoleService roleService, UserService userService) {
        this.orderRepository = orderRepository;
        this.courseService = courseService;
        this.roleService = roleService;
        this.userService = userService;
    }

    public Order getOrder(BigInteger id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(CourseInput courseInput) {

        User user = userService.getUser(courseInput.getCreatedBy());
        Role role = roleService.getRole(user.getRole().getId());
        log.info(role.toString());
        if(role.getId().compareTo(new BigInteger("1")) != 0){
            throw new RuntimeException("User role is not Student!");
        }
        Course course = courseService.insertCourse(courseInput);
        Order order = new Order();
        order.setCourse(course);
        order.setIsActive(true);
        return orderRepository.save(order);
    }

    public Order deleteOrder(BigInteger orderId){
        Order order = orderRepository.findById(orderId).get();
        order.setIsActive(false);
        return orderRepository.save(order);
    }

    public Order assignTeacher(OrderInput orderInput){
        Order order = orderRepository.findById(orderInput.getOrderId()).get();
        User tutor = userRepository.findById(orderInput.getTutorId()).get();
        order.setTutor(tutor);
        return orderRepository.save(order);
    }

    public Order cancelJobApplication(OrderInput orderInput){
        Order order = orderRepository.findById(orderInput.getOrderId()).get();
        if(order.getTutor().getId().compareTo(orderInput.getTutorId()) == 0){
            throw new RuntimeException("This teacher is not assigned to this order");
        }
        order.setTutor(null);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findByIsActive(true);
    }
}

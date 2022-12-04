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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
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
        User teacher = userRepository.findById(orderInput.getTeacherId()).get();
        order.setTeacher(teacher);
        return orderRepository.save(order);
    }

    public Order cancelJobApplication(OrderInput orderInput){
        Order order = orderRepository.findById(orderInput.getOrderId()).get();
        if(order.getTeacher().getId().compareTo(orderInput.getOrderId()) == 0){
            throw new RuntimeException("This teacher is not assigned to this order");
        }
        order.setTeacher(null);
        return orderRepository.save(order);
    }

    public Order cancelPrivateTeacherApplication(OrderInput orderInput){
        Order order = orderRepository.findById(orderInput.getOrderId()).get();
        order.setTeacher(null);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findByIsActive(true);
    }

    public List<Order> viewOwnOrder(Integer page, Integer size, BigInteger id){
        log.info("User ID: " + id);
        User user = userService.getUser(id);

        Pageable pageable = null;
        if(!(page == null || size == null)){
            pageable = PageRequest.of(page,size);
        }

        List<Order> order = null;
        if(user.getRole().getId().compareTo(new BigInteger("1")) == 0){
            // if student
            order = orderRepository.findByStudentId(id, pageable);
        }else{
            // if teacher
            order = orderRepository.findByTeacherId(id, pageable);
        }
        return order;
    }
}

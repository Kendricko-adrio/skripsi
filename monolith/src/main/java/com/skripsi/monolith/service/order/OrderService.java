package com.skripsi.monolith.service.order;

import com.skripsi.monolith.dto.course.CourseInput;
import com.skripsi.monolith.dto.order.OrderInput;
import com.skripsi.monolith.model.course.Course;
import com.skripsi.monolith.model.order.JobVacancy;
import com.skripsi.monolith.model.order.Order;
import com.skripsi.monolith.model.user.Role;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.repository.order.JobVacancyRepository;
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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    public Order getOrder(BigInteger id){
        return orderRepository.findById(id).orElse(null);
    }

//    public Order createOrder(CourseInput courseInput) {
//
//        User user = userService.getUser(courseInput.getCreatedBy());
//        Role role = roleService.getRole(user.getRole().getId());
//        if(role.getId().compareTo(new BigInteger("1")) != 0){
//            throw new RuntimeException("User role is not Student!");
//        }
//        Course course = courseService.insertCourse(courseInput);
//        Order order = new Order();
//        order.setCourse(course);
//        order.setIsActive(true);
//        return orderRepository.save(order);
//    }
    public Order createOrder(JobVacancy jobVacancy, BigInteger teacherId) {
        Order order = Order.builder()
                .course(jobVacancy.getCourse())
                .student(jobVacancy.getStudent())
                .teacher(User.builder().id(teacherId).build())
                .isActive(true)
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){

        return orderRepository.findByIsActive(true); 
    }

    public List<Order> viewOwnOrder(Integer page, Integer size, BigInteger id){
        log.info("User ID: " + id);
        Pageable pageable = null;
        if(!(page == null || size == null)){
            pageable = PageRequest.of(page,size);
        }

        List<Order> order = orderRepository.viewOrderedJob(id, pageable);
        return order;
    }
}

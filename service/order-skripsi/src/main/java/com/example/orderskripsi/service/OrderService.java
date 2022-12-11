package com.example.orderskripsi.service;

import com.example.orderskripsi.model.JobVacancy;
import com.example.orderskripsi.model.Order;
import com.example.orderskripsi.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    public Order getOrder(BigInteger id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(JobVacancy jobVacancy, BigInteger teacherId) {
        Order order = Order.builder()
                .courseId(jobVacancy.getCourseId())
                .studentId(jobVacancy.getStudentId())
                .teacherId(teacherId)
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

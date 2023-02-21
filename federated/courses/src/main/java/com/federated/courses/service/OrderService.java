package com.federated.courses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.courses.model.Response;
import com.federated.courses.model.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class OrderService extends ExternalBaseService{

    @Value("${external.order.url}")
    private String orderServiceUrl;
    private ObjectMapper mapper = new ObjectMapper();

    public List<Order> getAllOrder(){
        Response response = hitExternalService(orderServiceUrl + "/all", HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
    }

    public List<Order> viewOwnOrder(Integer page, Integer size, Integer userId){
        String url = orderServiceUrl + "?page="+ page + "&size=" + size + "&userId=" + userId;
        System.out.println(url);
        Response response = hitExternalService(url, HttpMethod.GET, null, null, Response.class);
        return mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Order.class));
    }
}

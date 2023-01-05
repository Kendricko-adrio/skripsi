package com.federated.courses.dgs;

import com.federated.courses.model.order.Order;
import com.federated.courses.service.OrderService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.math.BigInteger;
import java.util.List;

@DgsComponent
public class OrderDataFetcher {
    @Autowired
    private OrderService orderService;

//    @QueryMapping
//    public List<Order> viewOwnOrder(@Argument Integer page,
//                                    @Argument Integer size,
//                                    @Argument BigInteger userId) {
//        return orderService.viewOwnOrder(page, size, userId);
//    }

    @DgsQuery
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }
}

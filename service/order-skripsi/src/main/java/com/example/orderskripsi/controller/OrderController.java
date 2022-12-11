package com.example.orderskripsi.controller;

import com.example.orderskripsi.constant.ResponseMessage;
import com.example.orderskripsi.dto.BaseResponse;
import com.example.orderskripsi.model.Order;
import com.example.orderskripsi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.ResponseHandler;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

//  @QueryMapping
  @GetMapping
  public ResponseEntity<BaseResponse> viewOwnOrder(@RequestParam Integer page,
                                                   @RequestParam Integer size,
                                                   @RequestParam BigInteger userId) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, orderService.viewOwnOrder(page, size, userId));
  }

//  @QueryMapping
  @GetMapping("/all")
  public ResponseEntity<BaseResponse> getAllOrder() {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, orderService.getAllOrder());
  }
}

package com.example.orderskripsi.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderInput {
    private BigInteger orderId;
    private  BigInteger teacherId;
}

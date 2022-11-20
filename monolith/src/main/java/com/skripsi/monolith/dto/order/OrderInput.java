package com.skripsi.monolith.dto.order;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderInput {

    private BigInteger orderId;

    private  BigInteger tutorId;

}

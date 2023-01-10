package com.example.notificationskripsi.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ReadNotificationsRequest {

  private List<BigInteger> ids;

}

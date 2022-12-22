package com.example.orderskripsi.dto;

import com.example.orderskripsi.model.constants.NotificationStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NotificationRequest {
    private BigInteger userId;
    private String status;
}

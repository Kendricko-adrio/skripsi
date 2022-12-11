package com.example.notificationskripsi.dto;

import com.example.notificationskripsi.model.constants.NotificationStatus;
import lombok.Data;

import java.math.BigInteger;

@Data
public class NotificationRequest {
    private BigInteger userId;
    private NotificationStatus status;
}

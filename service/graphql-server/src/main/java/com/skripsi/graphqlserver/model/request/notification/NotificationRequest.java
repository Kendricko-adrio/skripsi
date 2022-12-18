package com.skripsi.graphqlserver.model.request.notification;

import com.skripsi.graphqlserver.constant.NotificationStatus;
import lombok.Data;

import java.math.BigInteger;

@Data
public class NotificationRequest {
    private BigInteger userId;
    private NotificationStatus status;
}

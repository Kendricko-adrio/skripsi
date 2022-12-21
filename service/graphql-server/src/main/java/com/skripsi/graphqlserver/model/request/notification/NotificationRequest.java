package com.skripsi.graphqlserver.model.request.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skripsi.graphqlserver.constant.NotificationStatus;
import lombok.Data;

import java.math.BigInteger;

@Data
public class NotificationRequest {

    @JsonProperty("user_id")
    private BigInteger userId;
    private NotificationStatus status;
}

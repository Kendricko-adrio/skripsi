package com.example.notificationskripsi.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String message;
    private int status;
    private Object data;
}

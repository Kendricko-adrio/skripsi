package com.example.orderskripsi.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String message;
    private int status;
    private Object data;
}

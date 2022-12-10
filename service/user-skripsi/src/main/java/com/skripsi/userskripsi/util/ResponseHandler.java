package com.example.courseskripsi.util;

import com.example.courseskripsi.constant.ResponseMessage;
import com.example.courseskripsi.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<BaseResponse> generateResponse(ResponseMessage message, Object responseObj) {
        BaseResponse response = new BaseResponse();
        response.setMessage(message.getMessage());
        response.setStatus(message.getStatus().value());
        response.setData(responseObj);
        return new ResponseEntity<>(response, message.getStatus());
    }
}

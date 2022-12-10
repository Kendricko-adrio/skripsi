package com.skripsi.userskripsi.util;

import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<BaseResponse> generateResponse(ResponseMessage message, Object responseObj) {
        BaseResponse response = new BaseResponse();
        response.setMessage(message.getMessage());
        response.setStatus(message.getStatus().value());
        response.setData(responseObj);
        return new ResponseEntity<>(response, message.getStatus());
    }
}

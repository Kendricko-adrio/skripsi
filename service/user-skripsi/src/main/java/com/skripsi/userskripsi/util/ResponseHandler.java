package com.skripsi.userskripsi.util;

import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.model.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Slf4j
public class ResponseHandler {

  public ResponseHandler() {
  }

  public static ResponseEntity<BaseResponse> generateResponse(ResponseMessage message,
      Object responseObj) {
    BaseResponse response = new BaseResponse();
    response.setMessage(message.getMessage());
    response.setStatus(message.getStatus().value());
    response.setData(responseObj);

    log.info("Response: {}", response);

    return new ResponseEntity<>(response, message.getStatus());
  }

  public static <T> Response<T> ok(T data) {
    return status(HttpStatus.OK, data);
  }

  public static <T> Response<T> status(HttpStatus httpStatus, T data) {
    return status(ResponseMessage.SUCCESS.getStatus(), ResponseMessage.SUCCESS.getMessage(), data);
  }

  public static <T> Response<T> status(HttpStatus httpStatus, String message, T data) {
    return (Response<T>) Response.builder().status(httpStatus.value()).message(message).data(data).build();
  }
}

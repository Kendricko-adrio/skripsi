package com.example.notificationskripsi.dto;

import org.springframework.http.HttpStatus;


public enum ResponseMessage {
    // create enum with message and http status class
    SUCCESS("Success", HttpStatus.OK),
    CREATED("Created", HttpStatus.CREATED),
    UPDATED("Updated", HttpStatus.OK),
    DELETED("Deleted", HttpStatus.OK),
    NOT_FOUND("Not Found", HttpStatus.NOT_FOUND),
    BAD_REQUEST("Bad Request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("Unauthorized", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("Forbidden", HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

    private String message;
    private HttpStatus status;
    ResponseMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public HttpStatus getStatus() {
        return status;
    }

}

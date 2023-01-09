package com.example.notificationskripsi.controller;

import com.example.notificationskripsi.dto.BaseResponse;
import com.example.notificationskripsi.dto.NotificationRequest;
import com.example.notificationskripsi.dto.ReadNotificationsRequest;
import com.example.notificationskripsi.dto.ResponseMessage;
import com.example.notificationskripsi.model.Notification;
import com.example.notificationskripsi.model.constants.NotificationStatus;
import com.example.notificationskripsi.service.NotificationService;
import com.example.notificationskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

  @Autowired
  private NotificationService notificationService;

  @GetMapping("/{userId}")
  public ResponseEntity<BaseResponse> getNotifications(@PathVariable BigInteger userId) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        notificationService.getNotifications(userId));
  }

  @PostMapping
  public ResponseEntity<BaseResponse> saveJobApplicationNotification(@RequestBody NotificationRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        notificationService.saveJobApplicationNotification(request.getUserId(),
            request.getStatus()));
  }

  @PostMapping("/read")
  public ResponseEntity<BaseResponse> readNotifications (@RequestBody ReadNotificationsRequest request) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS,
        notificationService.readNotifications(request.getIds()));
  }

}

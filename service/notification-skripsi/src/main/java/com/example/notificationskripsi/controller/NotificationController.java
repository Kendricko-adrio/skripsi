package com.example.notificationskripsi.controller;

import com.example.notificationskripsi.dto.NotificationRequest;
import com.example.notificationskripsi.model.Notification;
import com.example.notificationskripsi.model.constants.NotificationStatus;
import com.example.notificationskripsi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

  private NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

//  @QueryMapping
    @GetMapping("/{userId}")
  public List<Notification> getNotifications(@PathVariable BigInteger userId) {
    return notificationService.getNotifications(userId);
  }

//  @SchemaMapping
//  List<Notification> notifications(User user) {
//    return notificationService.getNotifications(user.getId());
//  }

  @PostMapping
  public Notification saveJobApplicationNotification(@RequestBody NotificationRequest request) {
    return notificationService.saveJobApplicationNotification(request.getUserId(), request.getStatus());
  }

}

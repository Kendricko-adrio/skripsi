package com.example.notificationskripsi.repository;

import com.example.notificationskripsi.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, BigInteger> {

  List<Notification> findAllByUserId(BigInteger id);
}

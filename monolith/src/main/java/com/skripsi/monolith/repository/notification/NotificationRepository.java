package com.skripsi.monolith.repository.notification;

import com.skripsi.monolith.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, BigInteger> {

  List<Notification> findAllByUser_Id(BigInteger id);
}

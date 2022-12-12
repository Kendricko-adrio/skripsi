package com.federated.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.users.model.Response;
import com.federated.users.model.constants.NotificationStatus;
import com.federated.users.model.notif.Notification;
import com.federated.users.model.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class NotificationService extends ExternalBaseService{

    @Value("${external.notif.url}")
    private String notifUrl;

    private ObjectMapper mapper = new ObjectMapper();

    public List<Notification> getNotifications(BigInteger userId) {
//        return repository.findAllByUser_Id(userId);
        Response response = hitExternalService(notifUrl + "/" + userId, HttpMethod.GET, null,null, Response.class);
        List<Notification> notifications = mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Notification.class));
        return notifications;
    }

//    public Notification saveJobApplicationNotification(BigInteger targetUser, NotificationStatus status) {
//        return repository.save(Notification.builder()
//                .content(status.name())
//                .read(false)
//                .user(targetUser)
//                .build());
//    }
}

package com.skripsi.graphqlserver.model.notification;

import com.skripsi.graphqlserver.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

  private BigInteger id;

  private User user;

  private String content;

  private boolean read;

}

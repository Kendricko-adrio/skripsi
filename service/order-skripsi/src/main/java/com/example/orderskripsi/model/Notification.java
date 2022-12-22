package com.example.orderskripsi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

//  private User user;

  @JsonProperty("user_id")
  private BigInteger userId;

  private String content;

  private boolean read;

}

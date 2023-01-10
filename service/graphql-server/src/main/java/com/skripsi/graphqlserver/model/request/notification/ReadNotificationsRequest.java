package com.skripsi.graphqlserver.model.request.notification;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
public class ReadNotificationsRequest {

  private List<BigInteger> ids;

}

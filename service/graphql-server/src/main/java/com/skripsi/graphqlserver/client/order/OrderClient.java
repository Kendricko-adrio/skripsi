package com.skripsi.graphqlserver.client.order;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.order.Order;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class OrderClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getOrder();
  }

  public OrderClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Order>> getAllOrder() {
    return get("order/all", new ParameterizedTypeReference<Response<List<Order>>>() {
    });
  }

  public Response<List<Order>> viewOwnOrder(Integer page, Integer size, BigInteger userId) {
    return get("order?page=" + page + "&size=" + size + "&userId=" + userId,
        new ParameterizedTypeReference<Response<List<Order>>>() {
        });
  }

}

package com.skripsi.graphqlserver.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("service")
public class ServiceProperties {

  private String user = "http://localhost:8081/api/";

}

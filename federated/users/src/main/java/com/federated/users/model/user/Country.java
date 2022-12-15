package com.federated.users.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.federated.users.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends BaseEntity {


  private BigInteger id;

  private String name;
}

package com.skripsi.monolith.model.user;

import com.skripsi.monolith.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private BigInteger id;

  private String username;

  private String email;

  private String password;

  private String name;

  @Column(name = "country_id")
  private BigInteger countryId;

  @Column(name = "role_id")
  private BigInteger roleId;
}

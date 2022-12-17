package com.skripsi.userskripsi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

  @Id
  private BigInteger id;

  private String name;

//  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//  private List<User> users;

}

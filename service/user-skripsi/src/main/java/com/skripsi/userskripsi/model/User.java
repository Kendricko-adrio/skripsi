package com.skripsi.userskripsi.model;

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
@Table(name = "users")
public class User extends BaseEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private BigInteger id;

  private String username;

  private String email;

  private String password;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  private Country country;



  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id")
  private Role role;

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private List<Notification> notifications;

}

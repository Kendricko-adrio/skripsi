package com.skripsi.monolith.model.notification;

import com.skripsi.monolith.model.BaseEntity;
import com.skripsi.monolith.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notifications")
public class Notification extends BaseEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private BigInteger id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  private String content;

  private boolean read;

}

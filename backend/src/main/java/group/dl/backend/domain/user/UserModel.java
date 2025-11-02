package group.dl.backend.domain.user;

import java.time.LocalDateTime;
import java.util.UUID;

import group.dl.backend.domain.store.StoreModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Getter
  private UUID id;

  @Getter
  @Setter
  @Column(nullable = false, unique = true)
  private String email;

  @Setter
  @Column(nullable = false)
  private String password;

  @Getter
  @Setter
  @Column(nullable = false, length = 100)
  private String name;

  @Getter
  @Setter
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Getter
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private StoreModel storeId;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  protected String getPassword() {
    return password;
  }
}

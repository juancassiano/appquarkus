package tech.buildrun.entity;

import jakarta.persistence.*;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "tb_users")
public class UserEntity extends PanacheEntityBase{
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  public UUID userId;
  public String username;
}

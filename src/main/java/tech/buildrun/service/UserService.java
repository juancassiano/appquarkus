package tech.buildrun.service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import tech.buildrun.entity.UserEntity;
import tech.buildrun.exception.UserNotFoundException;

@ApplicationScoped
public class UserService {

  public UserEntity createUser(UserEntity userEntity){
   UserEntity.persist(userEntity);
   return userEntity;
  }

  public List<UserEntity> findAll(Integer page, Integer size) {
    return UserEntity.findAll().page(page,size).list();
  }

  public UserEntity findById(UUID userId) {
    return (UserEntity) UserEntity.findByIdOptional(userId).orElseThrow(UserNotFoundException::new);
  }

  public UserEntity updateUser(UUID userId, UserEntity userEntity) {
    UserEntity user = findById(userId);
    user.username = userEntity.username;

    UserEntity.persist(user);
    return user;
  }

  public void deleteById(UUID userId) {
  UserEntity user = findById(userId);

  UserEntity.deleteById(user.userId);

  }
  
}

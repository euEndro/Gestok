package group.dl.backend.application.user.service;

import org.springframework.stereotype.Service;

<<<<<<< HEAD:backend/src/main/java/group/dl/backend/domain/user/UserService.java
import group.dl.backend.domain.user.dto.CreateUserDTO;
import group.dl.backend.domain.user.dto.UserResponseDTO;
=======
import group.dl.backend.domain.user.UserRepository;
>>>>>>> 2a9b7b3 (reworked the architecture to fit better the DDD, created a mapper for the user):backend/src/main/java/group/dl/backend/application/user/service/UserService.java

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public CreateUserDTO create()

  private UserResponseDTO toResponse(UserModel user) {
    return new UserResponseDTO(
        user.getId,
        user.getName,
        user.getRole,
        user.getCreatedAt,
        user.getStoreId);
  }
}

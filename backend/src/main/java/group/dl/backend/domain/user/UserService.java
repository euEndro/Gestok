package group.dl.backend.domain.user;

import org.springframework.stereotype.Service;

import group.dl.backend.domain.user.dto.CreateUserDTO;
import group.dl.backend.domain.user.dto.UserResponseDTO;

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

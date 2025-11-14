package group.dl.backend.application.user.mapper;

import org.springframework.stereotype.Component;

import group.dl.backend.application.user.dto.CreateUserDTO;
import group.dl.backend.application.user.dto.UserResponseDTO;
import group.dl.backend.domain.user.UserModel;

@Component
public class UserMapper {

  public UserResponseDTO toResponse(UserModel user) {
    return new UserResponseDTO(
        user.getId(),
        user.getName(),
        user.getRole(),
        user.getCreatedAt(),
        user.getStore().getId());
  }

  public UserModel toModel(CreateUserDTO createDTO) {
    UserModel user = new UserModel();
    user.setName(createDTO.name());
    user.setEmail(createDTO.email());
    user.setPassword(createDTO.password());
    return user;
  }
}

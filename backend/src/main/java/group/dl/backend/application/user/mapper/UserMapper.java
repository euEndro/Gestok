package group.dl.backend.application.user.mapper;

import group.dl.backend.application.user.dto.CreateUserDTO;
import group.dl.backend.application.user.dto.UserResponseDTO;
import group.dl.backend.domain.user.UserModel;

public class UserMapper {

  public static UserResponseDTO toResponse(UserModel user) {
    return new UserResponseDTO(
        user.getId(),
        user.getName(),
        user.getRole(),
        user.getCreatedAt(),
        user.getStore().getId());
  }

  public static UserModel toModel(CreateUserDTO createDTO) {
    UserModel user = new UserModel();
    user.setName(createDTO.name());
    user.setEmail(createDTO.email());
    user.setPassword(createDTO.password());
    return user;
  }
}

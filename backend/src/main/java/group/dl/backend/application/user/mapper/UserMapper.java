package group.dl.backend.application.user.mapper;

import group.dl.backend.application.user.dto.UserResponseDTO;
import group.dl.backend.domain.user.UserModel;

public class UserMapper {

  public static UserResponseDTO toResponse(UserModel user) {
    return new UserResponseDTO(
        user.getId(),
        user.getName(),
        user.getRole(),
        user.getCreatedAt(),
        user.getStoreId());
  }

  public static UserModel toModel(UserResponseDTO userDTO) {
    return new UserModel(
        userDTO.getName(),
        userDTO.getEmail(),
        userDTO.getPassword());
  }
}

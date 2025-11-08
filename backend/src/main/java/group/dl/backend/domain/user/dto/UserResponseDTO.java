package group.dl.backend.domain.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import group.dl.backend.domain.user.Role;

public record UserResponseDTO(
    UUID id,
    String nome,
    Role role,
    LocalDateTime createdAt,
    UUID storeId) {
}

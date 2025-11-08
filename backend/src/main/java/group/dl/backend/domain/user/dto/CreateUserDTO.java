package group.dl.backend.domain.user.dto;

import group.dl.backend.domain.user.Role;

public record CreateUserDTO(
    String email,
    String name,
    Role role) {
}

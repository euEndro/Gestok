package group.dl.backend.domain.store.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import group.dl.backend.domain.store.Plan;

public record StoreResponseDTO(
    UUID id,
    String name,
    Plan plan,
    LocalDateTime createdAt) {
}

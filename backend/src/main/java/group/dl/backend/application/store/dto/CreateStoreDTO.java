package group.dl.backend.application.store.dto;

import group.dl.backend.domain.store.Plan;

public record CreateStoreDTO(
    String name,
    Plan plan) {
}

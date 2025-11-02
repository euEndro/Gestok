package group.dl.backend.domain.store.dto;

import group.dl.backend.domain.store.Plan;

public record CreateStoreDTO(
    String name,
    Plan plan) {
}

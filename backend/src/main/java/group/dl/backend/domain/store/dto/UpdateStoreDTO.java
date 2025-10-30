package group.dl.backend.domain.store.dto;

import group.dl.backend.domain.store.Plan;

public record UpdateStoreDTO(
    String name,
    Plan plan) {
}

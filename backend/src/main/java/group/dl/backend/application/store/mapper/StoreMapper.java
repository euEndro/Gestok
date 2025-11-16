package group.dl.backend.application.store.mapper;

import org.springframework.stereotype.Component;

import group.dl.backend.application.store.dto.CreateStoreDTO;
import group.dl.backend.application.store.dto.StoreResponseDTO;
import group.dl.backend.domain.store.StoreModel;

@Component
public class StoreMapper {

  public StoreResponseDTO toResponse(StoreModel store) {
    return new StoreResponseDTO(
        store.getId(),
        store.getName(),
        store.getPlan(),
        store.getCreatedAt());
  }

  public StoreModel toModel(CreateStoreDTO createDTO) {
    StoreModel store = new StoreModel();
    store.setName(createDTO.name());
    store.setPlan(createDTO.plan());
    return store;
  }
}

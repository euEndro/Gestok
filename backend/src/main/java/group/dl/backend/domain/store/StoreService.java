package group.dl.backend.domain.store;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import group.dl.backend.domain.store.dto.CreateStoreDTO;
import group.dl.backend.domain.store.dto.StoreResponseDTO;
import group.dl.backend.domain.store.dto.UpdateStoreDTO;

@Service
public class StoreService {

  private final StoreRepository storeRepository;

  public StoreService(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  public StoreResponseDTO create(CreateStoreDTO dto) {
    StoreModel store = new StoreModel();
    store.setName(dto.name());
    store.setPlan(dto.plan());

    StoreModel saved = storeRepository.save(store);
    return toResponse(saved);
  }

  public List<StoreResponseDTO> findAll() {
    return storeRepository.findAll().stream()
        .map(this::toResponse)
        .collect(Collectors.toList());
  }

  public StoreResponseDTO findById(UUID id) {
    StoreModel store = storeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Store not found"));

    return toResponse(store);
  }

  public void delete(UUID id) {
    storeRepository.deleteById(id);
  }

  public StoreResponseDTO update(UUID id, UpdateStoreDTO newFields) {
    StoreModel store = storeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Store not found"));

    if (newFields.name() != null) {
      store.setName(newFields.name());
    }
    if (newFields.plan() != null) {
      store.setPlan(newFields.plan());
    }

    StoreModel updatedStore = storeRepository.save(store);
    return toResponse(store);
  }

  private StoreResponseDTO toResponse(StoreModel store) {
    return new StoreResponseDTO(
        store.getId(),
        store.getName(),
        store.getPlan(),
        store.getCreatedAt());
  }
}

package group.dl.backend.application.store.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import group.dl.backend.application.store.dto.CreateStoreDTO;
import group.dl.backend.application.store.dto.StoreResponseDTO;
import group.dl.backend.application.store.dto.UpdateStoreDTO;
import group.dl.backend.application.store.mapper.StoreMapper;
import group.dl.backend.domain.store.StoreModel;
import group.dl.backend.domain.store.StoreRepository;

@Service
public class StoreService {

  private final StoreRepository storeRepository;
  private final StoreMapper storeMapper;

  public StoreService(StoreRepository storeRepository, StoreMapper storeMapper) {
    this.storeRepository = storeRepository;
    this.storeMapper = storeMapper;
  }

  public StoreResponseDTO create(CreateStoreDTO createDto) {
    StoreModel store = storeRepository.save(storeMapper.toModel(createDto));
    return storeMapper.toResponse(store);
  }

  public List<StoreResponseDTO> findAll() {
    return storeRepository.findAll().stream()
        .map(storeMapper::toResponse)
        .toList();
  }

  public StoreResponseDTO findById(UUID id) {
    StoreModel store = storeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Store not found"));

    return storeMapper.toResponse(store);
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
    return storeMapper.toResponse(updatedStore);
  }

}

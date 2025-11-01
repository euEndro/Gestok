package group.dl.backend.domain.store;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.dl.backend.domain.store.dto.CreateStoreDTO;
import group.dl.backend.domain.store.dto.StoreResponseDTO;
import group.dl.backend.domain.store.dto.UpdateStoreDTO;

@RestController
@RequestMapping("/store")
public class StoreController {

  private final StoreService storeService;

  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @PostMapping
  public ResponseEntity<StoreResponseDTO> create(@RequestBody CreateStoreDTO request) {
    StoreResponseDTO createdStore = storeService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
  }

  @GetMapping
  public ResponseEntity<List<StoreResponseDTO>> findAll() {
    List<StoreResponseDTO> store = storeService.findAll();
    return ResponseEntity.ok(store);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StoreResponseDTO> findById(@PathVariable UUID id) {
    StoreResponseDTO store = storeService.findById(id);
    return ResponseEntity.ok(store);
  }

  @PatchMapping("/{id}/update")
  public ResponseEntity<StoreResponseDTO> update(@PathVariable UUID id, @RequestBody UpdateStoreDTO updatedStore) {
    StoreResponseDTO store = storeService.update(id, updatedStore);
    return ResponseEntity.ok(store);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    storeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

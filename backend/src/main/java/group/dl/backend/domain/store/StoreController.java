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

  @PatchMapping("/{id}/name")
  public ResponseEntity<StoreResponseDTO> updateName(@PathVariable UUID id, @RequestBody String updatedName) {
    StoreResponseDTO store = storeService.updateName(id, updatedName);
    return ResponseEntity.ok(store);
  }

  @PatchMapping("/{id}/plan")
  public ResponseEntity<StoreResponseDTO> updatedPlan(@PathVariable UUID id, @RequestBody Plan updatedPlan) {
    StoreResponseDTO store = storeService.updatePlan(id, updatedPlan);
    return ResponseEntity.ok(store);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@RequestBody UUID id) {
    storeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

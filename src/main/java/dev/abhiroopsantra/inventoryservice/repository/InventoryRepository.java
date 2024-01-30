package dev.abhiroopsantra.inventoryservice.repository;


import dev.abhiroopsantra.inventoryservice.dto.ItemsRequest;
import dev.abhiroopsantra.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    Optional<Inventory> findBySkuCode(String skuCode);
}

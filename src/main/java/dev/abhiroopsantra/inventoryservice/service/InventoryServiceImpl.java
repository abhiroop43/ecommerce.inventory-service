package dev.abhiroopsantra.inventoryservice.service;

import dev.abhiroopsantra.inventoryservice.exception.NotFoundException;
import dev.abhiroopsantra.inventoryservice.model.Inventory;
import dev.abhiroopsantra.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;
    @Override @Transactional(readOnly = true) public boolean checkIfProductIsInStock(String skuCode) {
        Optional<Inventory> foundInventory = inventoryRepository.findBySkuCode(skuCode);

        if(foundInventory.isEmpty()) {
            throw new NotFoundException("Product with skuCode %s not found".formatted(skuCode));
        }

        return foundInventory.get().getQuantity() > 0;
    }
}

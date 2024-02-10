package dev.abhiroopsantra.inventoryservice.service;

import dev.abhiroopsantra.inventoryservice.dto.CheckOrderAvailabilityDto;
import dev.abhiroopsantra.inventoryservice.dto.InventoryResponse;
import dev.abhiroopsantra.inventoryservice.dto.ItemsRequest;
import dev.abhiroopsantra.inventoryservice.exception.NotFoundException;
import dev.abhiroopsantra.inventoryservice.model.Inventory;
import dev.abhiroopsantra.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean checkIfProductIsInStock(String skuCode) {
        Optional<Inventory> foundInventory = inventoryRepository.findBySkuCode(skuCode);

        if (foundInventory.isEmpty()) {
            throw new NotFoundException("Product with skuCode %s not found".formatted(skuCode));
        }

        return foundInventory.get().getQuantity() > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> checkItemsAvailability(CheckOrderAvailabilityDto checkOrderAvailabilityRequest) {
//        log.info("Wait started");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("Wait ended");
        return checkOrderAvailabilityRequest.getItems().stream().map(this::checkIfItemRequestIsInStock).toList();
    }


    private InventoryResponse checkIfItemRequestIsInStock(ItemsRequest itemRequest) {
        return checkIfQuantityIsAvailable(itemRequest);
    }

    private InventoryResponse checkIfQuantityIsAvailable(ItemsRequest itemRequest) {
        Optional<Inventory> foundInventory = inventoryRepository.findBySkuCode(itemRequest.getSkuCode());

        if (foundInventory.isEmpty()) {
            throw new NotFoundException("Product with skuCode %s not found".formatted(itemRequest.getSkuCode()));
        }
        return InventoryResponse.builder().skuCode(itemRequest.getSkuCode())
                .inStock(foundInventory.get().getQuantity() > itemRequest.getQuantity()).build();
    }
}

package dev.abhiroopsantra.inventoryservice.service;

import dev.abhiroopsantra.inventoryservice.dto.CheckOrderAvailabilityDto;
import dev.abhiroopsantra.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    boolean checkIfProductIsInStock(String skuCode);

    List<InventoryResponse> checkItemsAvailability(CheckOrderAvailabilityDto checkOrderAvailabilityRequest);
}

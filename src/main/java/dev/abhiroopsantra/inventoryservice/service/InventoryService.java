package dev.abhiroopsantra.inventoryservice.service;

import dev.abhiroopsantra.inventoryservice.dto.CheckOrderAvailabilityDto;

public interface InventoryService {
    boolean checkIfProductIsInStock(String skuCode);

    boolean checkItemsAvailability(CheckOrderAvailabilityDto checkOrderAvailabilityRequest);
}

package dev.abhiroopsantra.inventoryservice.service;

public interface InventoryService {
    boolean checkIfProductIsInStock(String skuCode);
}

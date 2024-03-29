package dev.abhiroopsantra.inventoryservice.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder public class InventoryResponse {
    private String  skuCode;
    private boolean inStock;
}

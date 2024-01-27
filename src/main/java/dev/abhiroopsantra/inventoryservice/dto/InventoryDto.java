package dev.abhiroopsantra.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private UUID   id;
    private     String skuCode;
    private     int    quantity;
}

package dev.abhiroopsantra.inventoryservice.controller;

import dev.abhiroopsantra.inventoryservice.dto.ApiResponse;
import dev.abhiroopsantra.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> checkIfProductIsInStock(@PathVariable String skuCode) {
        boolean isAvailable = inventoryService.checkIfProductIsInStock(skuCode);
        ApiResponse response = new ApiResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("isAvailable", isAvailable);
        response.data = data;
        response.errCode = "200";
        response.errMessage = "Success";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

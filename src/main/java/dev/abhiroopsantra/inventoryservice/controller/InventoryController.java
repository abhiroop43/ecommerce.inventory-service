package dev.abhiroopsantra.inventoryservice.controller;

import dev.abhiroopsantra.inventoryservice.dto.ApiResponse;
import dev.abhiroopsantra.inventoryservice.dto.CheckOrderAvailabilityDto;
import dev.abhiroopsantra.inventoryservice.dto.InventoryResponse;
import dev.abhiroopsantra.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController @RequestMapping("/api/v1/inventory") @RequiredArgsConstructor public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/checkItemsAvailability") @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse> checkItemsAvailability(
            @RequestBody CheckOrderAvailabilityDto checkOrderAvailabilityRequest
                                                             ) {
        List<InventoryResponse> inventoryResponses = inventoryService.checkItemsAvailability(
                checkOrderAvailabilityRequest);
        ApiResponse             response = new ApiResponse();
        HashMap<String, Object> data     = new HashMap<>();
        data.put("isAvailable", inventoryResponses);
        response.data       = data;
        response.errCode    = "200";
        response.errMessage = "Success";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

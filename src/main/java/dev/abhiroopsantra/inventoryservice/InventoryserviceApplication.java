package dev.abhiroopsantra.inventoryservice;

import dev.abhiroopsantra.inventoryservice.model.Inventory;
import dev.abhiroopsantra.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return (args) -> {
            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("ABC123");
            inventory1.setQuantity(100);

            inventoryRepository.save(inventory1);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("ABC124");
            inventory2.setQuantity(0);

            inventoryRepository.save(inventory2);
        };
    }
}

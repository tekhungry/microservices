package com.tekhungry.retail.inventroy.controller;


import com.tekhungry.retail.inventroy.documents.Inventory;
import com.tekhungry.retail.inventroy.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping
    public @ResponseBody
    Mono<Inventory> addToInventory(@RequestBody Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    @GetMapping
    public @ResponseBody
    Flux<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

}

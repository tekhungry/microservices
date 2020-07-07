package com.tekhungry.retail.inventroy.repository;

import com.tekhungry.retail.inventroy.documents.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends ReactiveMongoRepository<Inventory,Long> {
}

package com.bookstore.service;

import com.bookstore.repository.InventoryRepository;

public class InventoryService {

    private InventoryRepository inventoryRepository;

    // Setter for Dependency Injection
    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void processBook() {
        inventoryRepository.storeBook();
        System.out.println("Book processed successfully.");
    }
}

package com.book;

import com.bookstore.service.InventoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookStoreApplication {
    public static void main(String[] args) {

        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get InventoryService bean
        InventoryService inventoryService = (InventoryService) context.getBean("inventoryService");

        // Call method
        inventoryService.processBook();
    }
}

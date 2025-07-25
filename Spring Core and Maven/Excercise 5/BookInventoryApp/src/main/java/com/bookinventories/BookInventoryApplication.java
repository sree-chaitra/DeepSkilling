package com.bookinventories;

import com.bookinventory.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookInventoryApplication {

    public static void main(String[] args) {

        // Load Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService Bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the Service
        bookService.addBook();
    }
}

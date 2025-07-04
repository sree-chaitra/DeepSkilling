package com.libraryinjection;

import com.libraryinjection.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApplication {

    public static void main(String[] args) {

        // Load Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService Bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Call the Service Method
        bookService.addBook();
    }
}

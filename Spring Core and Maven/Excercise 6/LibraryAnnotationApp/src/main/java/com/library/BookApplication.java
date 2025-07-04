package com.library;

import com.libraryannotation.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookApplication {

    public static void main(String[] args) {

        // Load Spring IoC Container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService Bean
        BookService bookService = context.getBean(BookService.class);

        // Call Service Method
        bookService.addBook();
    }
}

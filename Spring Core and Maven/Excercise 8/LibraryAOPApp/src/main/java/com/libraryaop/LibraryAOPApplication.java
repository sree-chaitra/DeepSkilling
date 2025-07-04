package com.libraryaop;

import com.libraryaop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryAOPApplication {

    public static void main(String[] args) {

        // Load Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService Bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test AOP functionality
        bookService.addBook();
        System.out.println("-----------------------");
        bookService.deleteBook();
    }
}

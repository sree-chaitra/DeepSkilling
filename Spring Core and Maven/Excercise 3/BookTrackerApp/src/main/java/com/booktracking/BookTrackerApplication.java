package com.booktracking;

import com.booktracker.service.BookProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTrackerApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookProcessor bookProcessor = (BookProcessor) context.getBean("bookProcessor");

        bookProcessor.processBook();
    }
}

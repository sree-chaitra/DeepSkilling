package com.booktracker.service;

import com.booktracker.repository.BookDatabase;

public class BookProcessor {

    private BookDatabase bookDatabase;

    public void setBookDatabase(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    public void processBook() {
        System.out.println("Starting book processing...");
        bookDatabase.saveBook();
        System.out.println("Book processing completed.");
    }
}

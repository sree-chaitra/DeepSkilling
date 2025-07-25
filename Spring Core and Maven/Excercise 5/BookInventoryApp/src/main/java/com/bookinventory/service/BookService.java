package com.bookinventory.service;

import com.bookinventory.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Adding a book...");
        bookRepository.saveBook();
        System.out.println("Book added successfully.");
    }
}

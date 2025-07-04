package com.libraryinjection.service;

import com.libraryinjection.repository.BookRepository;

public class BookService {

    private String libraryName;
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Library: " + libraryName);
        System.out.println("Adding a book...");
        bookRepository.saveBook();
        System.out.println("Book added successfully.");
    }
}

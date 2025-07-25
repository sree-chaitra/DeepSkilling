package LibraryManagementSystem;

import java.util.Arrays;
import java.util.Scanner;

public class LibrarySystem {

    static class Book implements Comparable<Book> {
        String bookId;
        String title;
        String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }

        @Override
        public int compareTo(Book other) {
            return this.title.compareToIgnoreCase(other.title);
        }
    }

    // Linear search
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary search (requires sorted list)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = books[mid].title.compareToIgnoreCase(targetTitle);
            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Java Programming", "James Gosling"),
            new Book("B002", "Python Basics", "Guido van Rossum"),
            new Book("B003", "Data Structures", "Robert Lafore"),
            new Book("B004", "Algorithms", "Thomas H. Cormen"),
            new Book("B005", "Clean Code", "Robert C. Martin")
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        // Linear Search
        System.out.println("\nSearching using Linear Search:");
        Book linearResult = linearSearch(books, title);
        if (linearResult != null) {
            System.out.println("Found: " + linearResult);
        } else {
            System.out.println("Book not found.");
        }

        // Binary Search
        Arrays.sort(books); // Required before binary search
        System.out.println("\nSearching using Binary Search:");
        Book binaryResult = binarySearch(books, title);
        if (binaryResult != null) {
            System.out.println("Found: " + binaryResult);
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();
    }
}

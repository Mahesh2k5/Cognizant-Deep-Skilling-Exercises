package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.listBooks();
    }
}

class BookService {
    private BookRepository repository;
    public void setBookRepository(BookRepository repository) { this.repository = repository; }
    public void listBooks() {
        System.out.println("Listing books from repository...");
        repository.fetchBooks();
    }
}

class BookRepository {
    public void fetchBooks() {
        System.out.println("Fetched Book A, Book B");
    }
}

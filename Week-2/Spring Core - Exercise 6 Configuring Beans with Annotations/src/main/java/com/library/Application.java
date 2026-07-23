package com.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@ComponentScan
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService service = context.getBean(BookService.class);
        service.listBooks();
        context.close();
    }
}

@Service
class BookService {
    @Autowired
    private BookRepository repository;
    public void listBooks() {
        System.out.println("Listing books using annotations...");
        repository.fetchBooks();
    }
}

@Repository
class BookRepository {
    public void fetchBooks() {
        System.out.println("Fetched annotated Book A, Book B");
    }
}

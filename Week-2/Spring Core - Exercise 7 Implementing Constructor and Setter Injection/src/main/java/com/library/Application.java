package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = context.getBean("bookService", BookService.class);
        service.doTasks();
    }
}

class BookService {
    private BookRepository repository;
    private NotificationService notificationService;

    // Constructor Injection
    public BookService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Setter Injection
    public void setBookRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void doTasks() {
        repository.fetchBooks();
        notificationService.sendNotification();
    }
}

class BookRepository {
    public void fetchBooks() { System.out.println("Fetching books..."); }
}
class NotificationService {
    public void sendNotification() { System.out.println("Sending notifications..."); }
}

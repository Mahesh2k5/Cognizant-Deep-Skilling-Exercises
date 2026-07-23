package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@SpringBootApplication
public class JpaRepositoryApp {
    public static void main(String[] args) {
        SpringApplication.run(JpaRepositoryApp.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product("Laptop", 999.99));
            repository.save(new Product("Mouse", 19.99));
            
            System.out.println("Finding all products...");
            List<Product> products = repository.findAll();
            for(Product p : products) {
                System.out.println(p.getName() + " - $" + p.getPrice());
            }
        };
    }
}

@Entity
class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    public Product() {}
    public Product(String name, double price) { this.name = name; this.price = price; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

interface ProductRepository extends JpaRepository<Product, Long> {}

package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            repository.save(new User("John Doe"));
            System.out.println("Saved User to DB!");
            repository.findAll().forEach(u -> System.out.println(u.getName()));
        };
    }
}

@Entity
class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    public User() {}
    public User(String name) { this.name = name; }
    public String getName() { return name; }
}

interface UserRepository extends CrudRepository<User, Long> {}

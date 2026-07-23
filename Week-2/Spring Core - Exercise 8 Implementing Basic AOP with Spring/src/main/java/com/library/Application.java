package com.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LibraryService service = context.getBean(LibraryService.class);
        service.doWork();
        context.close();
    }
}

@Service
class LibraryService {
    public void doWork() {
        System.out.println("Executing Basic AOP LibraryService.doWork()...");
    }
}

@Aspect
@Component
class LoggingAspect {
    @Before("execution(* com.library.LibraryService.*(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before execution");
    }
    @After("execution(* com.library.LibraryService.*(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After execution");
    }
}

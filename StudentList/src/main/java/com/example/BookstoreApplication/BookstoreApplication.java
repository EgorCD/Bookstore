package com.example.BookstoreApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookstoreApplication.domain.Book;
import com.example.BookstoreApplication.domain.BookRepository;
import com.example.BookstoreApplication.domain.Category;
import com.example.BookstoreApplication.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
	    return (args) -> {
	        log.info("save a couple of books");
	        repository.save(new Book("A Tale of Two Cities", "Charles Dickens", 1859, "978-1503219704", 9.99, null));
	        repository.save(new Book("Moby Dick", "Herman Melville", 1851, "978-1503280780", 12.99, null));    
	        
	        log.info("fetch all books");
	        for (Book book : repository.findAll()) {
	            log.info(book.toString());
	        }
	    };
	}
	
	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository categoryRepository) {
	    return (args) -> {
	        categoryRepository.save(new Category("Fiction"));
	        categoryRepository.save(new Category("Non-Fiction"));
	        categoryRepository.save(new Category("History"));
	        // ... more categories if needed
	    };
	}

}

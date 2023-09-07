package com.example.BookstoreApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    
    // In case of need of complicated sql queries can use @QYERY
    // @Query("SELECT * FROM students")
    
}
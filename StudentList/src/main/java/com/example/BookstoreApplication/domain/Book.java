package com.example.BookstoreApplication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Default constructor
    public Book() {
    }

    // Constructor
    public Book(String title, String author, int publicationYear, String isbn, double price, Category category) {
    	this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book {" +
               "id=" + id + ", " +
               "title='" + title + '\'' + ", " +
               "author='" + author + '\'' + ", " +
               "publicationYear=" + publicationYear + ", " +
               "isbn='" + isbn + '\'' + ", " +
               "price=" + price +
               '}';
    }
}


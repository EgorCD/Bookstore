package com.example.BookstoreApplication.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BookstoreApplication.domain.Book;
import com.example.BookstoreApplication.domain.BookRepository;
import com.example.BookstoreApplication.domain.Category;
import com.example.BookstoreApplication.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    // Create REST service that returns all books (JSON)
    @RequestMapping(value="/api/books", method=RequestMethod.GET)
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Create REST service that returns one book by ID (JSON)
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.GET)
    public @ResponseBody Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).orElse(null);  // Return null if the book is not found
    }
    
    @GetMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index"; // This refers to the index.html template
    }
    
    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }
    
    // Edit book
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "editbook";
        } else {
            return "redirect:/booklist";  // Or redirect to an error page if you'd like.
        }
    }
    
    @PostMapping("/saveEditedBook")
    public String saveEditedBook(@ModelAttribute Book bookForm) {
        // Here, bookForm should have the id populated.
        bookRepository.save(bookForm);
        return "redirect:/booklist";
    }
}
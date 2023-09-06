package com.example.BookstoreApplication.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.BookstoreApplication.domain.Book;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/index")
    public String displayBooks(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "index";
    }

    @PostMapping("/index")
    public String addBook(@ModelAttribute("newBook") Book book) {
        books.add(book);
        return "redirect:/index";
    }
}

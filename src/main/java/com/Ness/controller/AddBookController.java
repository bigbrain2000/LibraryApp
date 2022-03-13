package com.Ness.controller;

import com.Ness.model.Book;
import com.Ness.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public String viewBooks(@NotNull Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "../static/addBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "../static/index";
    }
}

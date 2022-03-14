package com.Ness.controller;

import com.Ness.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SortBooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/sortBooks")
    public String viewBooks(@NotNull Model model) {
        model.addAttribute("books", bookService.sortAscByAuthorAndTitle());
        return "../static/sortBooks";
    }

}

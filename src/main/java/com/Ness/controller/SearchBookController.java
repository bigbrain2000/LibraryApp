package com.Ness.controller;

import com.Ness.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/searchBook")
    public String viewBooks(@NotNull Model model, String keyword) {

        if(keyword != null) {
            model.addAttribute("books", bookService.findByTitle(keyword));
        }
        else {
            model.addAttribute("books", bookService.listAll());
        }

        return "../static/searchBook";
    }
}

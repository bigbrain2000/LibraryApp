package com.Ness.controller;

import com.Ness.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/deleteBook")
    public String viewBooks(@NotNull Model model) {
        model.addAttribute("books", bookService.listAll());
        return "../static/deleteBook";
    }


    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.delete(id);
        return "redirect:/deleteBook";
    }
}

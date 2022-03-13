package com.Ness.controller;

import com.Ness.model.Book;
import com.Ness.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateAuthorController {

    @Autowired
    private BookService bookService;

    @GetMapping("/updateBook")
    public String viewBooks(@NotNull Model model) {
        model.addAttribute("books", bookService.listAll());
        return "../static/updateBook";
    }

    @GetMapping("/updateBook/edit/{id}")
    public String editBookForm(@PathVariable Long id, @NotNull Model model) {
        model.addAttribute("book", bookService.get(id));
        return "../static/updateBookPage";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") @NotNull Book book) {

        //get book from database
        Book existingBook = bookService.get(id);
        existingBook.setId(id);
        existingBook.setAuthor(book.getAuthor());


        //update the author of the book
        bookService.updateBook(existingBook);
        return "redirect:/updateBook";
    }
}

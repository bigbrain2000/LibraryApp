package com.Ness.service;

import com.Ness.model.Book;
import com.Ness.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book get(Long id) {
        return bookRepository.findById(id).get();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByTitle(String keyword) {
        return bookRepository.findByTittle(keyword);
    }
}

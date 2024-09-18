package com.bookpals.bookpals.domain.books;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookGateway bookGateway;

    public BookService(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public Book create(Book book) {
        return bookGateway.create(book);
    }
    public Book update(Long id, Book book) {
        return bookGateway.update(id, book);
    }
    public List<Book> getAll() {
        return bookGateway.getAll();
    }

}

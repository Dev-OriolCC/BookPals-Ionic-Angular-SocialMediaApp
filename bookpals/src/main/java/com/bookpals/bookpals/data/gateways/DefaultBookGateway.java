package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.repositories.BookRepository;
import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.books.BookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultBookGateway implements BookGateway {
    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Long id, Book book) {
        return null;
    }
}

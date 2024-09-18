package com.bookpals.bookpals.domain.books;

import java.util.List;

public interface BookGateway {
    Book create(Book book);
    Book update(Long id, Book book);
    List<Book> getAll();
}

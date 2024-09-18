package com.bookpals.bookpals.domain.books;

public interface BookGateway {
    Book create(Book book);
    Book update(Long id, Book book);
}

package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.entities.BookEntity;
import com.bookpals.bookpals.data.repositories.BookRepository;
import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.books.BookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public Book toModel(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .apiId(bookEntity.getApiId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .imageUrl(bookEntity.getImageUrl())
                .pages(bookEntity.getPages())
                .isbn(bookEntity.getIsbn())
                .build();
    }
}

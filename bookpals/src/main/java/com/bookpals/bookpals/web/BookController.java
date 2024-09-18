package com.bookpals.bookpals.web;

import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.books.BookService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book-pals/api/v1/book")
@CrossOrigin
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        List<BookDTO> bookDTOList = bookService.getAll().stream().map(this::toDto).toList();
        return ResponseEntity.ok(bookDTOList);
    }

//    @GetMapping("/:userId")
//    public ResponseEntity<Set<BookDTO>> get

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BookDTO {
        private Long id;
        private String apiId;
        private String title;
        private String author;
        //private String genre;
        private String imageUrl;
        private Long pages;
        private String isbn;
    }

    private BookDTO toDto(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .apiId(book.getApiId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .imageUrl(book.getImageUrl())
                .pages(book.getPages())
                .isbn(book.getIsbn())
                .build();
    }

}

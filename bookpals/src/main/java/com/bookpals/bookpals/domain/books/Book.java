package com.bookpals.bookpals.domain.books;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Long id;
    private String apiId;
    private String title;
    private String author;
    //private String genre;
    private String imageUrl;
    private String pages;
    private String isbn;

}

package com.bookpals.bookpals.domain.users;

import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.genres.Genre;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String country;
    private Date birthday;
    private String imageUrl;
    private LocalDateTime createdAt;
    private Set<Book> books;
    private Set<Genre> genres;
}

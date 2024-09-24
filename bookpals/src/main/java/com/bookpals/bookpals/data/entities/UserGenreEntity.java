package com.bookpals.bookpals.data.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_genres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGenreEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private GenreEntity genres;

    public GenreEntity getGenres() {
        return genres;
    }

    public UserEntity getUsers() {
        return users;
    }
}

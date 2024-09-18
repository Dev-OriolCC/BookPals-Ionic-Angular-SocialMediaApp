package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.repositories.GenreRepository;
import com.bookpals.bookpals.domain.genres.Genre;
import com.bookpals.bookpals.domain.genres.GenreGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultGenreGateway implements GenreGateway {
    private final GenreRepository genreRepository;

    @Override
    public Genre create(Genre genre) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }
}

package com.bookpals.bookpals.domain.genres;

import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private final GenreGateway genreGateway;

    public GenreService(GenreGateway genreGateway) {
        this.genreGateway = genreGateway;
    }

    public Genre create(Genre genre) {
        return genreGateway.create(genre);
    }

    public Genre update(Genre genre) {
        return genreGateway.update(genre);
    }

}

package com.bookpals.bookpals.domain.genres;

import java.util.List;

public interface GenreGateway {

    Genre create(Genre genre);
    Genre update(Genre genre);
    List<Genre> getAll();
}

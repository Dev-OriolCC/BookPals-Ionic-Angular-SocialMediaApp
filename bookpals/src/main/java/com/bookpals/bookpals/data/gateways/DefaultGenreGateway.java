package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.entities.GenreEntity;
import com.bookpals.bookpals.data.repositories.GenreRepository;
import com.bookpals.bookpals.domain.genres.Genre;
import com.bookpals.bookpals.domain.genres.GenreGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultGenreGateway implements GenreGateway {
    private final GenreRepository genreRepository;

    @Override
    public Genre create(Genre genre) {
        return toModel(genreRepository.save(toEntity(genre)));
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public Genre toModel(GenreEntity genreEntity) {
        return Genre.builder().id(genreEntity.getId()).name(genreEntity.getName())
                .build();
    }
    public GenreEntity toEntity(Genre genre) {
        return GenreEntity.builder().id(genre.getId()).name(genre.getName()).build();
    }

}

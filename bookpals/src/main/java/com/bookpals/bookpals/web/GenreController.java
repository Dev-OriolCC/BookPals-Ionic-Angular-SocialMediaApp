package com.bookpals.bookpals.web;

import com.bookpals.bookpals.domain.genres.Genre;
import com.bookpals.bookpals.domain.genres.GenreService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-pals/api/v1/genre")
@CrossOrigin
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll() {
        List<GenreDTO> genreDTOList = genreService.getAll().stream().map(this::toDto).toList();
        return ResponseEntity.ok(genreDTOList);
    }

    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreDTO genreDTO) {
        return ResponseEntity.ok(toDto(genreService.create(toModel(genreDTO))));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class GenreDTO {
        private Long id;
        private String name;
    }

    private GenreDTO toDto(Genre genre) {
        return GenreDTO.builder().id(genre.getId()).name(genre.getName()).build();
    }

    private Genre toModel(GenreDTO genreDTO) {
        return Genre.builder().id(genreDTO.id).name(genreDTO.getName()).build();
    }

}

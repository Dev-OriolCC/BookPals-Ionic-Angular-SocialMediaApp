package com.bookpals.bookpals.data.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}

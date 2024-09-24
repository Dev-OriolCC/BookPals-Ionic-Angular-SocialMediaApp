package com.bookpals.bookpals.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * @OneToMany_Relationship
     * Book -* User
     * */
    @OneToMany(mappedBy = "genres")
    private Set<UserGenreEntity> userGenreEntities = new HashSet<>();

    public Set<UserGenreEntity> getUserGenreEntities() { return userGenreEntities; }
    public void setUserGenre(Set<UserGenreEntity> userGenreEntities) { this.userGenreEntities = userGenreEntities; }
    public void addUserGenre(UserGenreEntity userGenreEntity) { this.userGenreEntities.add(userGenreEntity); }
}

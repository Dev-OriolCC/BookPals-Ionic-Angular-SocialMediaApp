package com.bookpals.bookpals.data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_id", nullable = false)
    private String apiId;

    private String title;

    private String author;

    // Genre

    @Column(name = "image_url")
    private String imageUrl;

    private Long pages;

    private String isbn;

    /**
     * @OneToMany_Relationship
     * Book -* User
     */
    //@ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "books")
    private Set<UserBookEntity> userBookEntities = new HashSet<>();


    public Set<UserBookEntity> getUserBookEntity() {
        return userBookEntities;
    }
    public void setUserBooks(Set<UserBookEntity> userBookEntities) {
        this.userBookEntities = userBookEntities;
    }
    public void addUserBook(UserBookEntity userBookEntity) {
        this.userBookEntities.add(userBookEntity);
    }



}

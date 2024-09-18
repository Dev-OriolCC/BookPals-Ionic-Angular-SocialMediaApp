package com.bookpals.bookpals.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String bio;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Date birthday;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * @OneToOne_Relationship
     * User <--> ResetPasswordVerification
     */
    @OneToOne(mappedBy = "userEntity")
    private ResetPasswordVerificationEntity resetPasswordVerification;


    /**
     * @OneToMany_Relationship
     * User -* Book
     */
    //@ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "users")
    private Set<UserBookEntity> userBookEntities = new HashSet<>();

    public void addBookEntity(UserBookEntity userBookEntity) {
        this.userBookEntities.add(userBookEntity);
    }
    public Set<UserBookEntity> getUserBookEntity() {
        return userBookEntities;
    }
    public void setUserBooks(Set<UserBookEntity> userBookEntities) {
        this.userBookEntities = userBookEntities;
    }
    public void addUserBookEntity(UserBookEntity userBookEntity) {
        this.userBookEntities.add(userBookEntity);
    }


}

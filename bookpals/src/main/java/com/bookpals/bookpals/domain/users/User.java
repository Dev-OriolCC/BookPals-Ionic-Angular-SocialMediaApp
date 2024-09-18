package com.bookpals.bookpals.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String country;
    private Date birthday;
    //    private String genre;
    private String imageUrl;
    private LocalDateTime createdAt;

}

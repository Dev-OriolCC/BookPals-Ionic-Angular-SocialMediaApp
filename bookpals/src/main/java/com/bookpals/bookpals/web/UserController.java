package com.bookpals.bookpals.web;

import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.users.User;
import com.bookpals.bookpals.domain.users.UserService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/book-pals/api/v1/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> userDTOList = userService.getAll().stream().map(this::toDto).toList();
        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(userService.getUserById(id)));

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class UserDTO {
        private Long id;
        private String name;
        private String username;
        private String bio;
        private String country;
        private Date birthday;
        private String imageUrl;
        private LocalDateTime createdAt;
        //
        private Set<Book> books;
    }
    private UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .bio(user.getBio())
                .country(user.getCountry())
                .birthday(user.getBirthday())
                .imageUrl(user.getImageUrl())
                .createdAt(user.getCreatedAt())
                .books(user.getBooks())
                .build();
    }

}

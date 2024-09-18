package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.entities.UserBookEntity;
import com.bookpals.bookpals.data.entities.UserEntity;
import com.bookpals.bookpals.data.repositories.UserRepository;
import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.users.User;
import com.bookpals.bookpals.domain.users.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultUserGateway implements UserGateway {
    private final UserRepository userRepository;
    private final DefaultBookGateway defaultBookGateway;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        return toModel(userRepository.getById(id));
    }


    public User toModel(UserEntity userEntity) {
        Set<Book> books = userEntity.getUserBookEntities().stream()
                .map(UserBookEntity::getBooks)
                .map(defaultBookGateway::toModel)
                .collect(Collectors.toSet());

        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .bio(userEntity.getBio())
                .country(userEntity.getCountry())
                .birthday(userEntity.getBirthday())
                .imageUrl(userEntity.getImageUrl())
                .createdAt(userEntity.getCreatedAt())
                .books(books)
                .build();
    }
}

package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.entities.ResetPasswordVerificationEntity;
import com.bookpals.bookpals.data.entities.UserBookEntity;
import com.bookpals.bookpals.data.entities.UserEntity;
import com.bookpals.bookpals.data.repositories.ResetPasswordVerificationRepository;
import com.bookpals.bookpals.data.repositories.UserRepository;
import com.bookpals.bookpals.domain.books.Book;
import com.bookpals.bookpals.domain.resetpassword.ResetPasswordVerificationGateway;
import com.bookpals.bookpals.domain.users.User;
import com.bookpals.bookpals.domain.users.UserGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.time.DateUtils.addDays;

@Component
@RequiredArgsConstructor
public class DefaultUserGateway implements UserGateway {
    private final UserRepository userRepository;
    private final ResetPasswordVerificationRepository resetPasswordVerificationRepository;
    private final DefaultBookGateway defaultBookGateway;
    private final DefaultResetPasswordVerificationGateway resetPasswordVerificationGateway;


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

    /**
     * Request ResetPassword
     */
    @Override
    public void requestResetPassword(String email) {

        if(!userRepository.existsByEmail(email.trim().toLowerCase())) throw new RuntimeException("User with email: "+email+" not found!");
        try {
            String expirationDate = DateFormatUtils.format(addDays(new Date(), 1), "yyyy-MM-dd HH:mm:ss");
            String url = getVerificationUrl(UUID.randomUUID().toString(), "password");

            UserEntity userEntity = userRepository.getByEmail(email);
            if(userEntity.getResetPasswordVerification() != null) {
                resetPasswordVerificationRepository.delete(userEntity.getResetPasswordVerification());
            }
            resetPasswordVerificationGateway.create(userEntity, expirationDate, url);

            /* @TODO SEND EMAIL */
            System.out.println("URL: "+url);

        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }

    }

    @Override
    public User verifyResetPassword(String url) {
        if(isLinkExpired(url)) throw new RuntimeException("The link is expired!");
        try {
            ResetPasswordVerificationEntity resetEntity =  resetPasswordVerificationRepository.findByUrl(url);
            return toModel(resetEntity.getUserEntity());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Link not valid");
        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
        return null;
    }



    private boolean isLinkExpired(String url) {
        ResetPasswordVerificationEntity resetEntity =  resetPasswordVerificationRepository.findByUrl(url);
        return !resetEntity.getExpirationDate().isAfter(LocalDateTime.now());
    }
    private String getVerificationUrl(String key, String password) {
        return "http://localhost:PORT/api/v1/user/verify/"+password+"/"+key;
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

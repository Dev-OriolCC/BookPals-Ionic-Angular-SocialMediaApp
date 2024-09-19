package com.bookpals.bookpals.data.repositories;

import com.bookpals.bookpals.data.entities.ResetPasswordVerificationEntity;
import com.bookpals.bookpals.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetPasswordVerificationRepository extends JpaRepository<ResetPasswordVerificationEntity, Long> {
    //void create(UserEntity userEntity, String expirationDate, String url);
    //void save(Long userId, String expirationDate, String url);
    ResetPasswordVerificationEntity findByUrl(String url);
}


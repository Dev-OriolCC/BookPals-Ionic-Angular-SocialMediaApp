package com.bookpals.bookpals.data.repositories;

import com.bookpals.bookpals.data.entities.ResetPasswordVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetPasswordVerificationRepository extends JpaRepository<ResetPasswordVerificationEntity, Long> {
}

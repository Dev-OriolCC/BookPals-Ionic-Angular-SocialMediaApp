package com.bookpals.bookpals.data.repositories;

import com.bookpals.bookpals.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getById(Long id);
    boolean existsByEmail(String email);
    UserEntity getByEmail(String email);
}

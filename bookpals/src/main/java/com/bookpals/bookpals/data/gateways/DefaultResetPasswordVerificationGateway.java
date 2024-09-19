package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.entities.ResetPasswordVerificationEntity;
import com.bookpals.bookpals.data.entities.UserEntity;
import com.bookpals.bookpals.data.repositories.ResetPasswordVerificationRepository;
import com.bookpals.bookpals.domain.resetpassword.ResetPasswordVerification;
import com.bookpals.bookpals.domain.resetpassword.ResetPasswordVerificationGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.apache.commons.lang3.time.DateUtils.addDays;

@Component
@RequiredArgsConstructor
public class DefaultResetPasswordVerificationGateway implements ResetPasswordVerificationGateway {
    private final ResetPasswordVerificationRepository resetPasswordVerificationRepository;


    @Override
    public ResetPasswordVerification create(ResetPasswordVerification resetPasswordVerification) {
        return null;
    }

    @Override
    public void create(UserEntity user, String date, String url) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime expirationDate = LocalDateTime.parse(date, formatter);

        // @TODO: Check the error with new insertions (duplicate pkey)
        ResetPasswordVerificationEntity resetEntity = ResetPasswordVerificationEntity.builder()
                .userEntity(user)
                .expirationDate(expirationDate)
                .url(url)
                .build();
        resetPasswordVerificationRepository.save(resetEntity);
    }

    @Override
    public ResetPasswordVerification delete(ResetPasswordVerification resetPasswordVerification) {
        return null;
    }

    @Override
    public ResetPasswordVerification verify(String url) {
        return null;
    }

}

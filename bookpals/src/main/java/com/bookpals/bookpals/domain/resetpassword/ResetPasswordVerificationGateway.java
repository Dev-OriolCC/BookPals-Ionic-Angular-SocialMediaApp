package com.bookpals.bookpals.domain.resetpassword;

import com.bookpals.bookpals.data.entities.UserEntity;

public interface ResetPasswordVerificationGateway {
    ResetPasswordVerification create(ResetPasswordVerification resetPasswordVerification);
    void create(UserEntity user, String expirationDate, String url);
    ResetPasswordVerification delete(ResetPasswordVerification resetPasswordVerification);
    ResetPasswordVerification verify(String url);
}

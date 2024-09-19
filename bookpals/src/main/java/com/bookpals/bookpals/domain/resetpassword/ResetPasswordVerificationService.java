package com.bookpals.bookpals.domain.resetpassword;

import com.bookpals.bookpals.data.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordVerificationService {
    private final ResetPasswordVerificationGateway resetPasswordVerificationGateway;

    public ResetPasswordVerificationService(ResetPasswordVerificationGateway resetPasswordVerificationGateway) {
        this.resetPasswordVerificationGateway = resetPasswordVerificationGateway;
    }

    public ResetPasswordVerification create(ResetPasswordVerification resetPasswordVerification) {
        return resetPasswordVerificationGateway.create(resetPasswordVerification);
    }

    public void create(UserEntity user, String expirationDate, String url) {
        resetPasswordVerificationGateway.create(user, expirationDate, url);
    }


}

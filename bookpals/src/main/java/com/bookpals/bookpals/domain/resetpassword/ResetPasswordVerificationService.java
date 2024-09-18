package com.bookpals.bookpals.domain.resetpassword;

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

    public ResetPasswordVerification update(ResetPasswordVerification resetPasswordVerification) {
        return resetPasswordVerificationGateway.update(resetPasswordVerification);
    }


}

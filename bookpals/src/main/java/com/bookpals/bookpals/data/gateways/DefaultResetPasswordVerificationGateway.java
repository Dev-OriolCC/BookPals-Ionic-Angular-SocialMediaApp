package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.repositories.ResetPasswordVerificationRepository;
import com.bookpals.bookpals.domain.resetpassword.ResetPasswordVerification;
import com.bookpals.bookpals.domain.resetpassword.ResetPasswordVerificationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultResetPasswordVerificationGateway implements ResetPasswordVerificationGateway {
    private final ResetPasswordVerificationRepository resetPasswordVerificationRepository;

    @Override
    public ResetPasswordVerification create(ResetPasswordVerification resetPasswordVerification) {
        return null;
    }

    @Override
    public ResetPasswordVerification update(ResetPasswordVerification resetPasswordVerification) {
        return null;
    }
}

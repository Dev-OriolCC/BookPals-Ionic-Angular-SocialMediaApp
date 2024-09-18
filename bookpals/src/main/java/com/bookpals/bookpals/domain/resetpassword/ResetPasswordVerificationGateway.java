package com.bookpals.bookpals.domain.resetpassword;

public interface ResetPasswordVerificationGateway {
    ResetPasswordVerification create(ResetPasswordVerification resetPasswordVerification);
    ResetPasswordVerification update(ResetPasswordVerification resetPasswordVerification);

}

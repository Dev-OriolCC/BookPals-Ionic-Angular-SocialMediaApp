package com.bookpals.bookpals.domain.resetpassword;

import com.bookpals.bookpals.data.entities.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordVerification {

    private Long id;
    private UserEntity userId;
    private String url;
    private LocalDateTime expirationDate;

}

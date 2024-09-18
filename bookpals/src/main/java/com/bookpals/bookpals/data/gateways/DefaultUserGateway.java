package com.bookpals.bookpals.data.gateways;

import com.bookpals.bookpals.data.repositories.UserRepository;
import com.bookpals.bookpals.domain.users.User;
import com.bookpals.bookpals.domain.users.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultUserGateway implements UserGateway {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}

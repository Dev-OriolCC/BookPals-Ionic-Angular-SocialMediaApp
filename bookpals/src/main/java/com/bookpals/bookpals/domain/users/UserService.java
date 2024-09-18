package com.bookpals.bookpals.domain.users;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User create(User user) {
        return userGateway.create(user);
    }

    public User update(User user) {
        return userGateway.update(user);
    }
}

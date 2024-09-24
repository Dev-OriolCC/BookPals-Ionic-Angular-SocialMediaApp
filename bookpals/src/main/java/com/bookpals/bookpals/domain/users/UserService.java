package com.bookpals.bookpals.domain.users;

import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getAll() { return userGateway.getAll(); }
    public User getUserById(Long id) { return userGateway.getUserById(id); }
    public void requestResetPassword(String email) { userGateway.requestResetPassword(email); }
    public User verifyResetPassword(String url) { return userGateway.verifyResetPassword(url); }
}

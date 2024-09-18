package com.bookpals.bookpals.domain.users;

import java.util.List;

public interface UserGateway {

    User create(User user);
    User update(User user);
    List<User> getAll();
    User getUserById(Long id);

}

package com.hillel.polezhaiev.application.app.repo;

import com.hillel.polezhaiev.application.app.model.User;

public interface UserRepo {
    void save(User u);
    boolean existsByUsername(String name);
}

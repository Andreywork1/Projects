package com.hillel.polezhaiev.application.app.repo;

import com.hillel.polezhaiev.application.app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInMemoryRepo implements UserRepo{

    private List <User> users = new ArrayList<>();

    @Override
    public void save(User u) {
        users.add(u);
    }

    @Override
    public boolean existsByUsername(String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .collect(Collectors.toList()).size() > 0;
    }


}

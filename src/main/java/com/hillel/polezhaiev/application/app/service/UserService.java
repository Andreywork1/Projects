package com.hillel.polezhaiev.application.app.service;

import com.hillel.polezhaiev.application.app.exception.UserAlreadyExistsException;
import com.hillel.polezhaiev.application.app.model.User;
import com.hillel.polezhaiev.application.app.repo.UserRepo;

public class UserService implements SaveUser{

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void saveUser(String username, String password) throws UserAlreadyExistsException {
        User user = new User(username, password);

        if(userRepo.existsByUsername(username)){
            throw new UserAlreadyExistsException(username);
        }

        userRepo.save(user);

    }
}

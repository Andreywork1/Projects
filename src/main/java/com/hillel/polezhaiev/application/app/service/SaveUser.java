package com.hillel.polezhaiev.application.app.service;

import com.hillel.polezhaiev.application.app.exception.UserAlreadyExistsException;

public interface SaveUser {
    void saveUser(String username, String password) throws UserAlreadyExistsException;
}

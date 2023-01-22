package com.hillel.polezhaiev.application.users.repo;

import com.hillel.polezhaiev.application.users.exceptions.PasswordLengthException;
import com.hillel.polezhaiev.application.users.exceptions.UserPersistException;
import com.hillel.polezhaiev.application.users.model.Person;

public interface Repository {
    void save(Person u) throws UserPersistException;
    boolean existsByUsername(String username) throws UserPersistException;
    boolean checkSizePassword(String password) throws PasswordLengthException;

}

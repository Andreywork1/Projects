package com.hillel.polezhaiev.application.users.service;

import com.hillel.polezhaiev.application.users.exceptions.ExistsByUsernameException;
import com.hillel.polezhaiev.application.users.exceptions.PasswordLengthException;
import com.hillel.polezhaiev.application.users.exceptions.UserPersistException;

public interface SavePerson {
    void savePerson(String username, String password) throws ExistsByUsernameException, UserPersistException, PasswordLengthException;
}

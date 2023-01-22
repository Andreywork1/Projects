package com.hillel.polezhaiev.application.users.service;

import com.hillel.polezhaiev.application.users.exceptions.ExistsByUsernameException;
import com.hillel.polezhaiev.application.users.exceptions.PasswordLengthException;
import com.hillel.polezhaiev.application.users.exceptions.UserPersistException;
import com.hillel.polezhaiev.application.users.model.Person;
import com.hillel.polezhaiev.application.users.repo.Repository;

public class Service implements SavePerson{

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void savePerson(String username, String password) throws ExistsByUsernameException, UserPersistException, PasswordLengthException {
        Person person = new Person(username, password);

        if(repository.existsByUsername(username)){
            throw new ExistsByUsernameException(username);
        }

        repository.checkSizePassword(password);

        repository.save(person);

    }
}

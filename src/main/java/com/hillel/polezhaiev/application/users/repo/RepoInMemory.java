package com.hillel.polezhaiev.application.users.repo;

import com.hillel.polezhaiev.application.users.exceptions.PasswordLengthException;
import com.hillel.polezhaiev.application.users.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoInMemory implements Repository{

    List<Person> persons = new ArrayList<>();

    @Override
    public void save(Person u) {
        persons.add(u);
    }

    @Override
    public boolean existsByUsername(String username) {
        return persons.stream()
                .filter(person -> person.getUsername().equals(username))
                .collect(Collectors.toList()).size() > 0;
    }

    @Override
    public boolean checkSizePassword(String password) throws PasswordLengthException {
        return false;
    }
}

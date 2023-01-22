package com.hillel.polezhaiev.application.users.repo;

import com.hillel.polezhaiev.application.users.exceptions.PasswordLengthException;
import com.hillel.polezhaiev.application.users.exceptions.UserPersistException;
import com.hillel.polezhaiev.application.users.model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RepoInFile implements Repository{
    @Override
    public void save(Person u) throws UserPersistException {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream("users.txt", true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.write(String.format("Name: %s;\tpassword: %s;\n", u.getUsername(), u.getPassword()));

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            throw new UserPersistException(String.format("Unable to persist user %s ", u.getUsername()), e);
        }

    }

    @Override
    public boolean existsByUsername(String username) throws UserPersistException {

        try(FileInputStream fileInputStream = new FileInputStream("users.txt")){
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String string = bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
            String [] newString = string.split(";");

            return Arrays.stream(newString).anyMatch(name -> (name.substring(name.indexOf(' ') + 1)).equals(username));

        } catch(IOException e){
            throw new UserPersistException(String.format("Unable to persist user %s ", username), e);

        }
    }

    @Override
    public boolean checkSizePassword(String password) throws PasswordLengthException {

        while(password.length() < 8){
            throw new PasswordLengthException(password);

        }
        return true;

    }
}

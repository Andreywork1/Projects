package com.hillel.polezhaiev.application;

import com.hillel.polezhaiev.application.users.repo.RepoInFile;
import com.hillel.polezhaiev.application.users.repo.RepoInMemory;
import com.hillel.polezhaiev.application.users.repo.Repository;
import com.hillel.polezhaiev.application.users.service.SavePerson;
import com.hillel.polezhaiev.application.users.service.Service;
import com.hillel.polezhaiev.application.users.ui.UserInterface;

public class AppByMyself {
    public static void main(String[] args) {
        Repository repository = new RepoInFile();
        SavePerson savePerson = new Service(repository);
        UserInterface userInterface = new UserInterface(savePerson);
    }
}

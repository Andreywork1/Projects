package com.hillel.polezhaiev.projects.authentication_name_password;

import com.hillel.polezhaiev.projects.authentication_name_password.repo.RepoInFile;
import com.hillel.polezhaiev.projects.authentication_name_password.repo.Repository;
import com.hillel.polezhaiev.projects.authentication_name_password.service.SavePerson;
import com.hillel.polezhaiev.projects.authentication_name_password.service.Service;
import com.hillel.polezhaiev.projects.authentication_name_password.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        Repository repository = new RepoInFile();
        SavePerson savePerson = new Service(repository);
        UserInterface userInterface = new UserInterface(savePerson);
    }
}

package com.hillel.polezhaiev.application;

import com.hillel.polezhaiev.application.app.repo.UserInMemoryRepo;
import com.hillel.polezhaiev.application.app.repo.UserRepo;
import com.hillel.polezhaiev.application.app.service.UserService;
import com.hillel.polezhaiev.application.app.uin.UserApp;

public class AppByMyself {
    public static void main(String[] args) {

        UserRepo repo = new UserInMemoryRepo();
        UserService service = new UserService(repo);
        UserApp app = new UserApp(service);
    }
}

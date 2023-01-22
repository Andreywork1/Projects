package com.hillel.polezhaiev.application.users.exceptions;

public class ExistsByUsernameException extends Exception{

    public ExistsByUsernameException(String message){
        super(message);
    }
}

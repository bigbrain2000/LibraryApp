package com.Ness.exceptions;

public class UsernameAlreadyExistsException extends Exception{
    public UsernameAlreadyExistsException(String username) {
        super(String.format("User %s already exists!", username));
    }
}

package edu.LearnLink.school.exeption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String messege) {
        super(messege);
    }
}

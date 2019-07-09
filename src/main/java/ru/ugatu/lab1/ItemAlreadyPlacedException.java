package ru.ugatu.lab1;

public class ItemAlreadyPlacedException extends Exception {

    protected ItemAlreadyPlacedException(String message){
        super(message);
    }
}

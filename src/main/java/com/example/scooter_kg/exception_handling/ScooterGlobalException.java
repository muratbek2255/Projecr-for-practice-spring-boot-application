package com.example.scooter_kg.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ScooterGlobalException {
    @ExceptionHandler
    public ResponseEntity<ScooterIncorrectData> handleException(NoSuchScooterException exception) {
        ScooterIncorrectData data = new ScooterIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    //Отловка вообще всех исключений
    @ExceptionHandler
    public ResponseEntity<ScooterIncorrectData> handleException(Exception exception) {
        ScooterIncorrectData data = new ScooterIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

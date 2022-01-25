package com.ertugrul.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NationalIdNumberNotValidException extends RuntimeException {

    public NationalIdNumberNotValidException(String message) {
        super(message);
    }
}

package com.ertugrul.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//kullanıcı mevcut olduğunda gösterilecek özel hata tanımı
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}

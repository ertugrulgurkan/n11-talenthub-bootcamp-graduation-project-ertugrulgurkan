package com.ertugrul.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Kredi Başvurusu bulunmadığında gösterilecek özel hata tanımı
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreditApplicationNotFoundException extends RuntimeException {

    public CreditApplicationNotFoundException(String message) {
        super(message);
    }
}

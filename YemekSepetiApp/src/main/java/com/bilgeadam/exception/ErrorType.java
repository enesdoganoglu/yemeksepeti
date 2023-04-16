package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4000, "Parametre Hatası", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4100, "Müşteri adı veya şifre hatalı", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(4200, "Şifreler aynı değil", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4300, "Bu müşteri zaten kayıtlı", HttpStatus.BAD_REQUEST),
    CUSTOMER_NOT_FOUND(4400, "Böyle bir müşteri bulunamadı", HttpStatus.NOT_FOUND),

    REGUIRED_USER_INFORMATION_NOT_FOUND(4500, "Müşterinin gerekli bilgileri yok. Sipariş oluşturamazsınız",HttpStatus.NOT_FOUND),
    ACTIVATE_CODE_ERROR(4500, "Aktivasyon kod hatası", HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    HttpStatus httpStatus;
    }

package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class CustomerManagerException extends RuntimeException{

    private final ErrorType errorType;

    public CustomerManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

    public CustomerManagerException(ErrorType errorType){
        this.errorType = errorType;
    }


}

package com.candenizgumus.springbootdemo.exception;

// Bu sınıf tüm controller sınıfları için merkezi bir şekilde hata yönetimi sağlayacaktır.

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(DemoException.class)
    public ResponseEntity<ErrorMessage> handleDemoException(DemoException ex){
        ErrorType errorType = ex.getErrorType();
        return new ResponseEntity(createErrorMessage(ex),errorType.getStatus());
    }

    private ErrorMessage createErrorMessage(DemoException ex)
    {
       return ErrorMessage.builder().code(ex.getErrorType().getCode()).message(ex.getMessage()).build();
    }


    @ExceptionHandler(RuntimeException.class) // Hata yakalayici bir metod olduğunu belirtmek için.
    public ResponseEntity<String> handleException(){
       return ResponseEntity.badRequest().body("Uygulamada Runtime Exception olustu................");
    }
}

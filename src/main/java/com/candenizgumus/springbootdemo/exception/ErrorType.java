package com.candenizgumus.springbootdemo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  AUTH_NOT_FOUND(5001,"Böyle bir Auth bulunamadı", HttpStatus.NOT_FOUND),
  URUN_NOT_FOUND(5002,"Böyle bir Urun bulunamadı", HttpStatus.NOT_FOUND),
  MUSTERI_NOT_FOUND(5003,"Böyle bir Musteri bulunamadı", HttpStatus.NOT_FOUND),
  USERNAME_OR_PASSWORD_WRONG(5002,"Kullanıcı adı veya parola yanlış.", HttpStatus.I_AM_A_TEAPOT);



  private Integer code;
  private String message;
  private HttpStatus status;
}

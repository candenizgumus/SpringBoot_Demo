package com.candenizgumus.springbootdemo.dto.request;

// Kaydederken kullanıcıdan alınacak minimum fieldları içeren dto'yu class olarak değil record olarak kullanınız.

//Recordlar immutable yani değiştirilemez nesnelerdir.
public record MusteriSaveRequestDto(String username, String password, String ad) {}

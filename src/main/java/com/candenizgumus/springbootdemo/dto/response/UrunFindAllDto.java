package com.candenizgumus.springbootdemo.dto.response;

// Kaydederken kullanıcıdan alınacak minimum fieldları içeren dto'yu class olarak değil record olarak kullanınız.

//Recordlar immutable yani değiştirilemez nesnelerdir.
public record UrunFindAllDto(String ad, String marka, String model, Double fiyat,Double kdv) {}

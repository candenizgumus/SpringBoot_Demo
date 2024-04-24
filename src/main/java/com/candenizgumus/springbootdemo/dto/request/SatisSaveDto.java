package com.candenizgumus.springbootdemo.dto.request;

// Kaydederken kullanıcıdan alınacak minimum fieldları içeren dto'yu class olarak değil record olarak kullanınız.

import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;

//Recordlar immutable yani değiştirilemez nesnelerdir.
public record SatisSaveDto(Urun urun, Musteri musteri,Integer adet) {}

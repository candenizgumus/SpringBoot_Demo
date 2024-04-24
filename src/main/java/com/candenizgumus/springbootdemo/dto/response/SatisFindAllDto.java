package com.candenizgumus.springbootdemo.dto.response;

// Kaydederken kullanıcıdan alınacak minimum fieldları içeren dto'yu class olarak değil record olarak kullanınız.

import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;

import java.time.LocalDate;

//Recordlar immutable yani değiştirilemez nesnelerdir.
public record SatisFindAllDto(Urun urun, Musteri musteri, LocalDate tarih, Double toplamfiyat) {}

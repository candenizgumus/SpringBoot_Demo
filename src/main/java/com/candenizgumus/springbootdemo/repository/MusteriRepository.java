package com.candenizgumus.springbootdemo.repository;

import com.candenizgumus.springbootdemo.entity.Auth;
import com.candenizgumus.springbootdemo.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long>
{
    /*
    findBy : Eğer tekil kayıt gelecekse kullanılır.
    findAllBy: Eğer çoğul kayıt gelecekse kullanılır.

     */
    List<Musteri> findByAdAndAdres(String username, String adres);
    //List<Musteri> findAllByOrderByUsername();

    //limit-top
    //List<Musteri> findTopBy3OrderByUsername();

    // Belirli bir tarihden sonra kayıt olan müşterileri getir.
    /*List<Musteri> findAllByKayittarihiGreaterThan(Long kayitTarihi);*/

    /*
    Select * From tblmusteri where ad LIKE '%A'
     */
/*
    List<Musteri> findAllByAdLikeIgnoreCase(String ifade);
    List<Musteri> findAllByAdContainingIgnoreCase(String ifade);
    List<Musteri> findAllByAdStartingWithIgnoreCase(String ifade);
    List<Musteri> findAllByAdEndingWithIgnoreCase(String ifade);
    List<Musteri> findAllByOrderByTelDesc(String ifade);
    List<Musteri> findAllByTelIsNull(String ifade);
    List<Musteri> findAllByKayittarihiBetween(Long start, Long end);*/

}

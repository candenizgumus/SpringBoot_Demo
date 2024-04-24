package com.candenizgumus.springbootdemo.repository;

import com.candenizgumus.springbootdemo.entity.Satis;
import com.candenizgumus.springbootdemo.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SatisRepository extends JpaRepository<Satis,Long>
{
    @Query("SELECT m.ad, s.urun.ad FROM Musteri m, Satis s WHERE s.musteri.id = m.id")
    List<Object[]> findSalesByMusteriAdWithProductList();

    List<Satis> findByMusteri_Ad(String ad);

    @Query("SELECT s.musteri.ad AS müsteri_ad , SUM(s.adet) AS toplam_satin_alim_adeti FROM Satis s GROUP BY s.musteri ORDER BY SUM(s.adet) DESC LIMIT 1")
    Object[] findTopCustomer();

    @Query("SELECT s.urun.ad, SUM(s.adet) FROM Satis s GROUP BY s.urun.ad ORDER BY SUM(s.adet) DESC LIMIT 3")
    List<Object[]> findTop3Product();





    // @Query("SELECT s.urun.ad FROM Satis s WHERE s.musteri.ad = :customerName")
  //  List<String> findProductsSoldToCustomer(@Param("customerName") String customerName);






}

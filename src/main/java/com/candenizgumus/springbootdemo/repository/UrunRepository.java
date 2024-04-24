package com.candenizgumus.springbootdemo.repository;

import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrunRepository extends JpaRepository<Urun,Long>
{
    List<Urun> findAllByOrderByFiyatDesc();




}

package com.candenizgumus.springbootdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Formula;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblsatis")
public class Satis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Urun urun;
    @ManyToOne
    Musteri musteri;
    @CreationTimestamp
    LocalDate tarih;
    Integer adet;
    Double toplamfiyat;

}
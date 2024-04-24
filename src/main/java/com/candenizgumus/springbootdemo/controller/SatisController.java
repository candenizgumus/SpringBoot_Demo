package com.candenizgumus.springbootdemo.controller;


import com.candenizgumus.springbootdemo.dto.request.SatisSaveDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.SatisFindAllDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Satis;
import com.candenizgumus.springbootdemo.entity.Urun;
import com.candenizgumus.springbootdemo.service.SatisService;
import com.candenizgumus.springbootdemo.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.candenizgumus.springbootdemo.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT+SATIS)
@RequiredArgsConstructor
public class SatisController
{
    private final SatisService satisService;

    /* @PostMapping("save")
     public ResponseEntity<Musteri> save(@RequestBody Musteri musteri){
        return ResponseEntity.ok(musteriService.save(musteri)) ;
     }*/

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody SatisSaveDto dto)
    {
        satisService.saveDto(dto);
        return ResponseEntity.ok("Kayıt Başarılı");
    }

    @PostMapping("/save2")
    @CrossOrigin("*")
    public ResponseEntity<String> save2(@RequestBody Satis satis)
    {
        satisService.save(satis);
        return ResponseEntity.ok("Kayıt Başarılı");
    }




    @GetMapping(FINDALL)
    public ResponseEntity<List<Satis>> findAll()
    {
        return ResponseEntity.ok(satisService.findAll());
    }





    @GetMapping(FINDALLDTO)
   public ResponseEntity<List<SatisFindAllDto>> findAllDto(){
        return ResponseEntity.ok(satisService.findAllResponseDtos());
   }


    @GetMapping("/musterisatislari")
    public ResponseEntity<List<Object[]>> getSalesByMusteriAdWithProductList() {
        List<Object[]> sales = satisService.findSalesByMusteriAdWithProductList();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/findurunlerbyad")
    public ResponseEntity<List<Urun>> findByMusteri_Ad(String ad) {
        List<Satis> satislar = satisService.findByMusteri_Ad(ad);
        List<Urun> uruns = new ArrayList<>();
        satislar.forEach(satis -> uruns.add(satis.getUrun()));
        return ResponseEntity.ok(uruns);
    }

    @GetMapping("/findtopcustomer")
    public ResponseEntity<Object[]> findTopCustomer() {

        return ResponseEntity.ok(satisService.findTopCustomer());
    }


    @GetMapping("/findtop3product")
    public ResponseEntity<List<Object[]>> findTop3Product() {

        return ResponseEntity.ok(satisService.findTop3Product());
    }





}

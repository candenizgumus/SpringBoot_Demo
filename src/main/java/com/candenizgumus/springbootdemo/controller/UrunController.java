package com.candenizgumus.springbootdemo.controller;


import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;
import com.candenizgumus.springbootdemo.service.MusteriService;
import com.candenizgumus.springbootdemo.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springbootdemo.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT+URUN)
@RequiredArgsConstructor
public class UrunController
{
    private final UrunService urunService;

    /* @PostMapping("save")
     public ResponseEntity<Musteri> save(@RequestBody Musteri musteri){
        return ResponseEntity.ok(musteriService.save(musteri)) ;
     }*/

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody UrunSaveDto dto)
    {
        urunService.saveDto(dto);
        return ResponseEntity.ok("Kayıt Başarılı");
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Urun>> findAll()
    {
        return ResponseEntity.ok(urunService.findAll());
    }





    @GetMapping(FINDALLDTO)
   public ResponseEntity<List<UrunFindAllDto>> findAllDto(){
        return ResponseEntity.ok(urunService.findAllResponseDtos());
   }

   @GetMapping(FINDALLORDERBYFIYAT)
    public List<Urun>  findAllByOrderByFiyatDesc(){
        return urunService.findAllByOrderByFiyatDesc();
    }

    @GetMapping("/hata")
    public String hataFirlat(){
        throw new RuntimeException("Hata firlatildi.");
    }



}

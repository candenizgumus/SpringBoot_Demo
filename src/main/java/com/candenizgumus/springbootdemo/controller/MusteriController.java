package com.candenizgumus.springbootdemo.controller;



import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import static com.candenizgumus.springbootdemo.constant.EndPoints.*;
@RestController
@RequestMapping(ROOT+MUSTERI)
@RequiredArgsConstructor
public class MusteriController
{
    private final MusteriService musteriService;

    /* @PostMapping("save")
     public ResponseEntity<Musteri> save(@RequestBody Musteri musteri){
        return ResponseEntity.ok(musteriService.save(musteri)) ;
     }*/
    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody MusteriSaveRequestDto dto)
    {
        musteriService.saveDto(dto);
        return ResponseEntity.ok("Kayıt Başarılı");
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Musteri>> findAll()
    {
        return ResponseEntity.ok(musteriService.findAll());
    }


    @GetMapping("/findbynameandadres")
    public ResponseEntity<List<Musteri>> findByNameAndAdres(String name, String adres)
    {
        return ResponseEntity.ok(musteriService.findByAdAndAdres(name, adres));
    }


    @GetMapping(FINDALLDTO)
   public ResponseEntity<List<MusteriFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(musteriService.findAllResponseDtos());
   }


}

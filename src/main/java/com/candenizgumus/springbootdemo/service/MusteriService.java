package com.candenizgumus.springbootdemo.service;

import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.entity.Auth;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.mapper.MusteriMapper;
import com.candenizgumus.springbootdemo.repository.AuthRepository;
import com.candenizgumus.springbootdemo.repository.MusteriRepository;
import com.candenizgumus.springbootdemo.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MusteriService extends ServiceManager<Musteri,Long>
{
  private final MusteriRepository musteriRepository;

  public MusteriService(MusteriRepository musteriRepository)
  {
    super(musteriRepository);
    this.musteriRepository = musteriRepository;

  }


  public List<Musteri> findByAdAndAdres(String username, String adres){
   return musteriRepository.findByAdAndAdres(username,adres);
  }

  public void saveDto(MusteriSaveRequestDto dto){
    // Bu metod içine dışarıdan gönderilen dto'dan bir müşteri nesnesi oluşturmanız gerekli.

  /*  Musteri kaydedilecekMusteri = Musteri.builder().username(dto.getUsername()).password(dto.getPassword()).ad(dto.getAd()).build();*/

    Musteri kaydedilecekMusteri = MusteriMapper.INSTANCE.musteriSaveRequestDtoToMusteri(dto);

    musteriRepository.save(kaydedilecekMusteri);
    //save(kaydedilecekMusteri); bu metod servicemanager içinde tanımlı olan save metodunu çağırmaktadır.
  }
  public List<MusteriFindAllResponseDto> findAllResponseDtos(){
    //findAll ile bir müsteri listesi çekilecek.
    //ardından bu liste içindeki her bir müşteriyi müşterifindallresponsedto'ya dönüştüreceğiz.
    List<MusteriFindAllResponseDto> responseDtoList = new ArrayList<>();

    findAll().forEach(musteri -> {
      /*MusteriFindAllResponseDto dto = MusteriFindAllResponseDto.builder()
              .ad(musteri.getAd())
              .username(musteri.getUsername())
              .img(musteri.getImg())
              .build();*/

      responseDtoList.add(MusteriMapper.INSTANCE.musteriToMusteriFindAllResponseDto(musteri));

    });


    return  responseDtoList;
  }

}

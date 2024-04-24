package com.candenizgumus.springbootdemo.service;

import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;
import com.candenizgumus.springbootdemo.mapper.MusteriMapper;
import com.candenizgumus.springbootdemo.mapper.UrunMapper;
import com.candenizgumus.springbootdemo.repository.MusteriRepository;
import com.candenizgumus.springbootdemo.repository.UrunRepository;
import com.candenizgumus.springbootdemo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UrunService extends ServiceManager<Urun,Long>
{
  private final UrunRepository urunRepository;

  public UrunService(UrunRepository urunRepository)
  {
    super(urunRepository);
    this.urunRepository = urunRepository;

  }
  public void saveDto(UrunSaveDto dto){

    Urun kaydedilecekUrun = UrunMapper.INSTANCE.urunToUrunSaveDto(dto);

    urunRepository.save(kaydedilecekUrun);

  }
  public List<UrunFindAllDto> findAllResponseDtos(){

    List<UrunFindAllDto> responseDtoList = new ArrayList<>();

    findAll().forEach(urun -> {


      responseDtoList.add(UrunMapper.INSTANCE.UrunToFindAllDtoToUrun(urun));

    });


    return  responseDtoList;
  }


  public List<Urun>  findAllByOrderByFiyatDesc(){
    return urunRepository.findAllByOrderByFiyatDesc();
  }

}

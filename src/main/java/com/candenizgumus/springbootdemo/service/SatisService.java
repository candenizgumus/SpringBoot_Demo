package com.candenizgumus.springbootdemo.service;

import com.candenizgumus.springbootdemo.dto.request.SatisSaveDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.SatisFindAllDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Satis;
import com.candenizgumus.springbootdemo.entity.Urun;
import com.candenizgumus.springbootdemo.exception.DemoException;
import com.candenizgumus.springbootdemo.exception.ErrorType;
import com.candenizgumus.springbootdemo.mapper.SatisMapper;
import com.candenizgumus.springbootdemo.mapper.UrunMapper;
import com.candenizgumus.springbootdemo.repository.SatisRepository;
import com.candenizgumus.springbootdemo.repository.UrunRepository;
import com.candenizgumus.springbootdemo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SatisService extends ServiceManager<Satis,Long>
{
  private final SatisRepository satisRepository;
  private final UrunService urunService;

  private final MusteriService musteriService;


  public SatisService(SatisRepository satisRepository, UrunService urunService, MusteriService musteriService)
  {
    super(satisRepository);
    this.satisRepository = satisRepository;

      this.urunService = urunService;

      this.musteriService = musteriService;
  }


  public void saveDto(SatisSaveDto dto)
  {

    Satis satis = SatisMapper.INSTANCE.satisToSatisSaveDto(dto);
    Optional<Musteri> musteri = musteriService.findById(dto.musteri().getId());
    if (musteri.isPresent())
    {
      calculateAndSetToplamSatis(dto, satis);
      save(satis);
    }else
    {
      throw new DemoException(ErrorType.MUSTERI_NOT_FOUND);
    }

  }

  private void calculateAndSetToplamSatis(SatisSaveDto dto, Satis satis)
  {
    Optional<Urun> urun = urunService.findById(dto.urun().getId());
    if (urun.isPresent())
    {
      satis.setToplamfiyat(urun.get().getFiyat()* satis.getAdet());
    }else
    {
      throw new DemoException(ErrorType.URUN_NOT_FOUND);
    }

  }

  public List<SatisFindAllDto> findAllResponseDtos()
  {
    List<SatisFindAllDto> responseDtoList = new ArrayList<>();

    findAll().forEach(satis -> {


      responseDtoList.add(SatisMapper.INSTANCE.SatisToFindAllToSatis(satis));

    });

    return responseDtoList;
  }

  public List<Object[]> findSalesByMusteriAdWithProductList() {
    return satisRepository.findSalesByMusteriAdWithProductList();
  }

  public List<Satis> findByMusteri_Ad(String ad){
    return satisRepository.findByMusteri_Ad(ad);
  }
  public Object[] findTopCustomer(){
    return satisRepository.findTopCustomer();
  }

  public List<Object[]> findTop3Product(){
    return satisRepository.findTop3Product();
  }
}

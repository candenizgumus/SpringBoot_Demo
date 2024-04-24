package com.candenizgumus.springbootdemo.mapper;

import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import com.candenizgumus.springbootdemo.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrunMapper
{
    UrunMapper INSTANCE = Mappers.getMapper( UrunMapper.class );


    Urun urunToUrunSaveDto(UrunSaveDto dto);
    UrunFindAllDto UrunToFindAllDtoToUrun(Urun urun);

}

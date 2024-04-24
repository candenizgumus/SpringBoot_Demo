package com.candenizgumus.springbootdemo.mapper;

import com.candenizgumus.springbootdemo.dto.request.MusteriSaveRequestDto;
import com.candenizgumus.springbootdemo.dto.response.MusteriFindAllResponseDto;
import com.candenizgumus.springbootdemo.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusteriMapper
{
    MusteriMapper INSTANCE = Mappers.getMapper( MusteriMapper.class );

    MusteriFindAllResponseDto musteriToMusteriFindAllResponseDto(Musteri musteri);
    Musteri musteriSaveRequestDtoToMusteri(MusteriSaveRequestDto dto);
}

package com.candenizgumus.springbootdemo.mapper;

import com.candenizgumus.springbootdemo.dto.request.SatisSaveDto;
import com.candenizgumus.springbootdemo.dto.request.UrunSaveDto;
import com.candenizgumus.springbootdemo.dto.response.SatisFindAllDto;
import com.candenizgumus.springbootdemo.dto.response.UrunFindAllDto;
import com.candenizgumus.springbootdemo.entity.Satis;
import com.candenizgumus.springbootdemo.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SatisMapper
{
    SatisMapper INSTANCE = Mappers.getMapper( SatisMapper.class );


    Satis satisToSatisSaveDto(SatisSaveDto dto);
    SatisFindAllDto SatisToFindAllToSatis(Satis satis);

}

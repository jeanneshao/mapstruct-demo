package com.sj.mapstructdemo.structmapper;

import com.sj.mapstructdemo.dto.BoxDto;
import com.sj.mapstructdemo.dto.ShelveDto;
import com.sj.mapstructdemo.entity.BoxEntity;
import com.sj.mapstructdemo.entity.ShelveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Jeanne 2023/5/3
 **/
@Mapper
public interface StorageMapper {
    StorageMapper INSTANCE = Mappers.getMapper( StorageMapper.class );
    @ToEntity
    @Mapping( target = "weightLimit", source = "maxWeight")
    ShelveEntity map(ShelveDto source);

    @ToEntity
    @Mapping( target = "label", source = "designation")
    BoxEntity map(BoxDto source);
}

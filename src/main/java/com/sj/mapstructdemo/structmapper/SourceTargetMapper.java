/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.sj.mapstructdemo.structmapper;


import com.sj.mapstructdemo.pojo.Source;
import com.sj.mapstructdemo.pojo.Target;
import com.sj.mapstructdemo.structmapper.util.MappingUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import org.mapstruct.factory.Mappers;

/**
 * @author Adam Gurgul
 */

@Mapper( uses = MappingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping(source = "map", target = "ip", qualifiedBy = MappingUtil.Ip.class )
    @Mapping(source = "map", target = "server", qualifiedBy = MappingUtil.Server.class )
    Target toTarget(Source s);
}

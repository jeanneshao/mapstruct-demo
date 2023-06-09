/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.sj.mapstructdemo.structmapper;

import com.sj.mapstructdemo.pojo.Department;
import com.sj.mapstructdemo.pojo.Employee;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import org.mapstruct.factory.Mappers;

import java.util.Map;

/**
 * @author Filip Hrisafov
 */
@Mapper
public interface MapToBeanMapper {

    MapToBeanMapper INSTANCE = Mappers.getMapper(MapToBeanMapper.class);

    @Mapping(target = "department", ignore = true)
    Employee fromMap(Map<String, String> map);

    @AfterMapping
    default void finishEmployee(@MappingTarget Employee employee, Map<String, String> map) {
        employee.setDepartment(fromMapToDepartment(map));
    }

    @Mapping(target = "id", source = "did")
    @Mapping(target = "name", source = "dname")
    Department fromMapToDepartment(Map<String, String> map);
}

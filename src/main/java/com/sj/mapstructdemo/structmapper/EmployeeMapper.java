/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.sj.mapstructdemo.structmapper;

import com.sj.mapstructdemo.dto.EmployeeDto;
import com.sj.mapstructdemo.pojo.Employee;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

/**
 * @author Filip Hrisafov
 */
@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper( EmployeeMapper.class );

    @Mapping(source = "employeeName", target = "name")
    Employee toEmployee(EmployeeDto employeeDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    EmployeeDto fromEmployee(Employee employee, @Context CycleAvoidingMappingContext context);
}

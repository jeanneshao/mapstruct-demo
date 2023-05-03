package com.sj.mapstructdemo.structmapper;

import com.sj.mapstructdemo.dto.CarDto;
import com.sj.mapstructdemo.dto.PersonDto;
import com.sj.mapstructdemo.entity.Car;
import com.sj.mapstructdemo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Jeanne 2023/5/3
 **/
@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
    default PersonDto personToPersonDto(Person person) {
        return  new PersonDto();
        //hand-written mapping logic
    }
}

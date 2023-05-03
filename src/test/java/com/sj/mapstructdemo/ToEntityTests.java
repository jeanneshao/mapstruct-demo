package com.sj.mapstructdemo;

import com.sj.mapstructdemo.dto.BoxDto;
import com.sj.mapstructdemo.dto.CarDto;
import com.sj.mapstructdemo.dto.ShelveDto;
import com.sj.mapstructdemo.entity.BoxEntity;
import com.sj.mapstructdemo.entity.Car;
import com.sj.mapstructdemo.entity.CarType;
import com.sj.mapstructdemo.entity.ShelveEntity;
import com.sj.mapstructdemo.structmapper.CarMapper;
import com.sj.mapstructdemo.structmapper.StorageMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ToEntityTests {

    @Test
    public void shouldMapCarToDto() {
        //given
        ShelveDto shelveDto = ShelveDto.builder().groupName("testToEntity").maxWeight(3321l).id(1233l).build();
        BoxDto boxDto = BoxDto.builder().groupName("boxDto").designation("test").id(3333l).build();

        //when
        ShelveEntity shelveEntity = StorageMapper.INSTANCE.map(shelveDto);
        BoxEntity boxEntity = StorageMapper.INSTANCE.map(boxDto);

        //then
        assertThat( shelveEntity ).isNotNull();


    }
}

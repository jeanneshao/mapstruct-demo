package com.sj.mapstructdemo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Jeanne 2023/5/3
 **/
@Data
public class EmployeeDto {
    private String employeeName;
    private EmployeeDto reportsTo;
    private List<EmployeeDto> team;

}

package com.sj.mapstructdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jeanne 2023/5/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String make;
    private int numberOfSeats;
    private CarType type;

    //constructor, getters, setters etc.
}

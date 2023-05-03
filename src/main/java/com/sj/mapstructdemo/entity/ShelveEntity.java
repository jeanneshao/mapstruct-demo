package com.sj.mapstructdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Jeanne 2023/5/3
 **/
@Data
public class ShelveEntity {
    private long id;
    private Date creationDate;
    private String name;
    private long weightLimit;
}

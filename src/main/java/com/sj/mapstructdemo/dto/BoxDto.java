package com.sj.mapstructdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Jeanne 2023/5/3
 **/
@Data
@Builder
public class BoxDto {
    private long id;
    private Date creationDate;
    private String groupName;
    private String designation;

}

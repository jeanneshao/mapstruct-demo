package com.sj.mapstructdemo;

import com.sj.mapstructdemo.pojo.Department;
import com.sj.mapstructdemo.pojo.Employee;
import com.sj.mapstructdemo.structmapper.MapToBeanMapper;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Filip Hrisafov
 */
public class MapToBeanMapperTest {

    @Test
    public void shouldMapMapToBean() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "1234");
        map.put("name", "Tester");
        map.put("did", "4321"); //Department Id
        map.put("dname", "Test");// Depart name

        Employee employee = MapToBeanMapper.INSTANCE.fromMap(map);

        assertNotNull(employee);
        assertEquals(employee.getId(), "1234");
        assertEquals(employee.getName(), "Tester");

        Department department = employee.getDepartment();
        assertNotNull(department);
        assertEquals(department.getId(), "4321");
        assertEquals(department.getName(), "Test");
    }
}

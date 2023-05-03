/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.sj.mapstructdemo;

import com.sj.mapstructdemo.dto.EmployeeDto;
import com.sj.mapstructdemo.pojo.Employee;
import com.sj.mapstructdemo.structmapper.CycleAvoidingMappingContext;
import com.sj.mapstructdemo.structmapper.EmployeeMapper;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Filip Hrisafov
 */
public class EmployeeMapperTest {

    @Test
    public void testMapDtoToEntity() {

        EmployeeDto teamLeader = employeeDto( "Group Leader", null );

        EmployeeDto member1 = employeeDto( "Member2", teamLeader );
        EmployeeDto member2 = employeeDto( "Member2", teamLeader );
        teamLeader.setTeam( Arrays.asList( member1, member2 ) );

        Employee teamLead = EmployeeMapper.MAPPER.toEmployee( teamLeader, new CycleAvoidingMappingContext() );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.getReportsTo() ).isNull();
        List<Employee> team = teamLead.getTeam();
        assertThat( team ).hasSize( 2 );
        assertThat( team ).extracting( "reportsTo" ).containsExactly( teamLead, teamLead );
    }

    private EmployeeDto employeeDto(String name, EmployeeDto reportsTo) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName( name );
        employeeDto.setReportsTo( reportsTo );
        return employeeDto;
    }

    @Test
    public void testMapEntityToDto() {

        Employee teamLeader = employee( "Group Leader", null );

        Employee member1 = employee( "Member2", teamLeader );
        Employee member2 = employee( "Member2", teamLeader );
        teamLeader.setTeam( Arrays.asList( member1, member2 ) );

        EmployeeDto teamLead = EmployeeMapper.MAPPER.fromEmployee( teamLeader, new CycleAvoidingMappingContext() );

        assertThat( teamLead ).isNotNull();
        assertThat( teamLead.getReportsTo() ).isNull();
        List<EmployeeDto> team = teamLead.getTeam();
        assertThat( team ).hasSize( 2 );
        assertThat( team ).extracting( "reportsTo" ).containsExactly( teamLead, teamLead );
    }

    private Employee employee(String name, Employee reportsTo) {
        Employee employee = new Employee();
        employee.setName( name );
        employee.setReportsTo( reportsTo );
        return employee;
    }
}

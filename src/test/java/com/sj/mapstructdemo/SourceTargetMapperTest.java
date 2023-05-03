/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.sj.mapstructdemo;

import com.sj.mapstructdemo.pojo.Source;
import com.sj.mapstructdemo.pojo.Target;
import com.sj.mapstructdemo.structmapper.SourceTargetMapper;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Adam Gurgul
 */
public class SourceTargetMapperTest {

    public SourceTargetMapperTest() {
    }

    /**
     * Test of toTarget method, of class SourceTargetMapper.
     */
    @Test
    public void testMapperOnExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        map.put("ip", "127.0.0.1");
        map.put("server", "168.192.1.1");

        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        assertEquals(t.getIp(), "127.0.0.1");
        assertEquals(t.getServer(), "168.192.1.1");

    }

    @Test
    public void testMapperOnNonExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        assertNull(t.getIp());
        assertNull(t.getServer());

    }



}

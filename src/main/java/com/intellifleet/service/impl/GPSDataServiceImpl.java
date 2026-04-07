package com.intellifleet.service.impl;


import com.intellifleet.constants.ApiHttpStatus;
import com.intellifleet.dto.ApiResponseEntity;
import com.intellifleet.dto.InstrumentPacketForRedisDTO;
import com.intellifleet.service.GPSDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class GPSDataServiceImpl implements GPSDataService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public ApiResponseEntity getGpsData() {

        return new ApiResponseEntity(ApiHttpStatus.OK, getAllGPSData());
    }

    @Override
    public List<InstrumentPacketForRedisDTO> getAllGPSData() {

        Set<String> keys = redisTemplate.keys("gps-data::*");

        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<InstrumentPacketForRedisDTO> result = new ArrayList<>();

        for (String key : keys) {
            Object value = redisTemplate.opsForValue().get(key);

            if (value instanceof InstrumentPacketForRedisDTO dto) {
                result.add(dto);
            }
        }

        return result;
    }

}

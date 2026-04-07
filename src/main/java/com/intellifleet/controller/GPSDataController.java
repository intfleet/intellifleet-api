package com.intellifleet.controller;


import com.intellifleet.api.GpsDataAPI;
import com.intellifleet.constants.ApiHttpStatus;
import com.intellifleet.dto.ApiResponseEntity;
import com.intellifleet.service.GPSDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gpsdata")
@RestController
@Slf4j
public class GPSDataController implements GpsDataAPI {

    @Autowired
    GPSDataService gpsDataService;

    @Override
    public ResponseEntity<ApiResponseEntity> getGpsData() {
        log.info("Started executing API getGroupList");
        ApiResponseEntity resp = new ApiResponseEntity(ApiHttpStatus.INTERNAL_SERVER_ERROR);
        resp = gpsDataService.getGpsData();
        return ResponseEntity.status(resp.getStatus()).body(resp);
    }
}

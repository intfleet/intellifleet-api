package com.intellifleet.api;

import com.intellifleet.dto.ApiResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gps-data")
@Tag(name = "GPS Data API", description = "Endpoints for GPS Data Controller")
public interface GpsDataAPI {

    @GetMapping
    ResponseEntity<ApiResponseEntity> getGpsData();
}

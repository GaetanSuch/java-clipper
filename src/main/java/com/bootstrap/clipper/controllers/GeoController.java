package com.bootstrap.clipper.controllers;

import com.bootstrap.clipper.clients.GeocodingClient;
import com.bootstrap.clipper.models.dto.DistanceResponse;
import com.bootstrap.clipper.models.dto.GeocodingResult;
import com.bootstrap.clipper.services.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/geo")
@RequiredArgsConstructor
public class GeoController {

    private final GeocodingClient geocodingClient;
    private final GeoService geoService;

    @GetMapping("/distance")
    public ResponseEntity<DistanceResponse> getDistance(
            @RequestParam String from,
            @RequestParam String to) {

        GeocodingResult fromResult = geocodingClient.geocode(from);
        GeocodingResult toResult = geocodingClient.geocode(to);

        double distanceKm = geoService.calculateDistance(
                fromResult.latitude(), fromResult.longitude(),
                toResult.latitude(), toResult.longitude()
        );

        return ResponseEntity.ok(new DistanceResponse(
                fromResult.address(),
                fromResult.latitude(),
                fromResult.longitude(),
                toResult.address(),
                toResult.latitude(),
                toResult.longitude(),
                Math.round(distanceKm * 100.0) / 100.0
        ));
    }
}

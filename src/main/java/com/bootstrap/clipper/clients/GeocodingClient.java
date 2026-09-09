package com.bootstrap.clipper.clients;

import com.bootstrap.clipper.models.dto.GeocodingResult;

public interface GeocodingClient {
    GeocodingResult geocode(String address);
    GeocodingResult reverseGeocode(double latitude, double longitude);
}

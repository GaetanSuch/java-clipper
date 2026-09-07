package com.bootstrap.clipper.models.dto;

import java.util.List;

public record GeocodingResult(
        String address,
        Double latitude,
        Double longitude,
        Double score
) {

    // DTOs internes pour la désérialisation GeoJSON de data.geopf.fr
    public record ApiResponse(String type, List<ApiFeature> features) {}
    public record ApiFeature(ApiGeometry geometry, ApiProperties properties) {}
    public record ApiGeometry(String type, List<Double> coordinates) {}
    public record ApiProperties(String label, Double score, String city, String postcode, String street) {}

    public static GeocodingResult from(ApiFeature feature) {
        return new GeocodingResult(
                feature.properties().label(),
                feature.geometry().coordinates().get(1), // lat = index 1
                feature.geometry().coordinates().get(0), // lng = index 0
                feature.properties().score()
        );
    }
}

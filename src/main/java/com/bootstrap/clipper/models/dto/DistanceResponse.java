package com.bootstrap.clipper.models.dto;

public record DistanceResponse(
        String fromAddress,
        Double fromLatitude,
        Double fromLongitude,
        String toAddress,
        Double toLatitude,
        Double toLongitude,
        Double distanceKm
) {}

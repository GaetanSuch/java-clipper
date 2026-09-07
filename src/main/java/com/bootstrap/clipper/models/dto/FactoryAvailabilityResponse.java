package com.bootstrap.clipper.models.dto;

public record FactoryAvailabilityResponse(
        Long id,
        String name,
        Integer production,
        Integer stock,
        Double distanceKm
) {}

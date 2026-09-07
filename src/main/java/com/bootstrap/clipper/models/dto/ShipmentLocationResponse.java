package com.bootstrap.clipper.models.dto;

public record ShipmentLocationResponse(
        String name,
        String address,
        Double latitude,
        Double longitude
) {}

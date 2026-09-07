package com.bootstrap.clipper.models.dto;

import java.time.LocalDateTime;

public record ShipmentResponse(
        Long id,
        ShipmentLocationResponse factory,
        ShipmentLocationResponse store,
        Integer quantity,
        Double distanceKm,
        String status,
        LocalDateTime departedAt,
        LocalDateTime estimatedArrivalAt
) {}

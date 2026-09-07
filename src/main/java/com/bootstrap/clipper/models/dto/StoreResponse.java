package com.bootstrap.clipper.models.dto;

public record StoreResponse(
        Long id,
        String name,
        Integer stock,
        String address,
        Double latitude,
        Double longitude
) {}

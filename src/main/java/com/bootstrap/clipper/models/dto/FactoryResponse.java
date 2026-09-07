package com.bootstrap.clipper.models.dto;

public record FactoryResponse(
        Long id,
        String name,
        Integer production,
        Integer stock,
        String address,
        Double latitude,
        Double longitude
) {}

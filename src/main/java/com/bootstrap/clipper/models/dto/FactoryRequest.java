package com.bootstrap.clipper.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FactoryRequest(
        @NotBlank(message = "Le nom est obligatoire")
        String name,

        @NotNull(message = "La production est obligatoire")
        @Positive(message = "La production doit être positive")
        Integer production,

        @NotBlank(message = "L'adresse est obligatoire")
        String address
) {}

package com.bootstrap.clipper.models.dto;

import jakarta.validation.constraints.NotBlank;

public record StoreRequest(
        @NotBlank(message = "Le nom est obligatoire")
        String name,

        @NotBlank(message = "L'adresse est obligatoire")
        String address
) {}

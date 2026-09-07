package com.bootstrap.clipper.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SupplyRequest(
        @NotNull(message = "L'id de l'usine est obligatoire")
        Long factoryId,

        @NotNull(message = "La quantité est obligatoire")
        @Positive(message = "La quantité doit être positive")
        Integer quantity
) {}

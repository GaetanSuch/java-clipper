package com.bootstrap.clipper.clients;

import com.bootstrap.clipper.configurations.exceptions.type.BadRequestException;
import com.bootstrap.clipper.models.dto.GeocodingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class GeocodingClient {

    private final RestClient restClient;
    private final double minScore;

    public GeocodingClient(@Value("${clipper.geocoding.base-url}") String baseUrl,
                           @Value("${clipper.geocoding.min-score:0.80}") double minScore) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.minScore = minScore;
    }

    public GeocodingResult geocode(String address) {
        log.info("🌍 Géocodage : '{}'", address);

        GeocodingResult.ApiResponse response = restClient.get()
                .uri("/search/?q={address}&limit=1", address)
                .retrieve()
                .body(GeocodingResult.ApiResponse.class);

        if (response == null || response.features() == null || response.features().isEmpty()) {
            throw new BadRequestException("Adresse introuvable : " + address);
        }

        GeocodingResult result = GeocodingResult.from(response.features().getFirst());

        if (result.score() < minScore) {
            throw new BadRequestException(
                    "Adresse trop imprécise : '" + address + "' (score: " + result.score() + ", minimum: " + minScore + ")");
        }

        log.info("📍 Résultat : {} [{}, {}] (score: {})",
                result.address(), result.latitude(), result.longitude(), result.score());

        return result;
    }

    public GeocodingResult reverseGeocode(double latitude, double longitude) {
        log.info("🌍 Reverse géocodage : [{}, {}]", latitude, longitude);

        GeocodingResult.ApiResponse response = restClient.get()
                .uri("/reverse/?lat={lat}&lon={lon}&limit=1", latitude, longitude)
                .retrieve()
                .body(GeocodingResult.ApiResponse.class);

        if (response == null || response.features() == null || response.features().isEmpty()) {
            throw new BadRequestException(
                    "Aucune adresse trouvée pour les coordonnées : " + latitude + ", " + longitude);
        }

        return GeocodingResult.from(response.features().getFirst());
    }
}

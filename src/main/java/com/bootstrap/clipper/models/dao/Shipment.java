package com.bootstrap.clipper.models.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factory_id")
    private Factory factory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column()
    private Integer quantity;

    @Column()
    private Double distanceKm;

    @Enumerated(EnumType.STRING)
    @Column()
    private ShipmentStatus status;

    @Column()
    private LocalDateTime departedAt;

    @Column()
    private LocalDateTime estimatedArrivalAt;

    @Column()
    private LocalDateTime deliveredAt;
}

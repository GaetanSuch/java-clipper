package com.bootstrap.clipper.models.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column()
    private String name;

    @Builder.Default
    @Column()
    private Integer stock = 0;

    @Version
    private Long version;

    @Transient
    private String address;

    @Column()
    private Double latitude;

    @Column()
    private Double longitude;

    public void addStock(int quantity) {
        this.stock += quantity;
    }
}

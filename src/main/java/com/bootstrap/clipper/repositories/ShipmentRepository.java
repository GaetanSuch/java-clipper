package com.bootstrap.clipper.repositories;

import com.bootstrap.clipper.models.dao.Shipment;
import com.bootstrap.clipper.models.dao.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByStatusAndEstimatedArrivalAtBefore(ShipmentStatus status, LocalDateTime dateTime);

    @Query("SELECT s FROM Shipment s JOIN FETCH s.factory JOIN FETCH s.store WHERE s.store.id = :storeId AND s.status = :status")
    List<Shipment> findByStoreIdAndStatus(@Param("storeId") Long storeId, @Param("status") ShipmentStatus status);
}

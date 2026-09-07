package com.bootstrap.clipper.models.mappers;

import com.bootstrap.clipper.models.dao.Factory;
import com.bootstrap.clipper.models.dao.Shipment;
import com.bootstrap.clipper.models.dao.Store;
import com.bootstrap.clipper.models.dto.ShipmentLocationResponse;
import com.bootstrap.clipper.models.dto.ShipmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    @Mapping(expression = "java(shipment.getStatus().name())", target = "status")
    ShipmentResponse toResponse(Shipment shipment);

    List<ShipmentResponse> toResponseList(List<Shipment> shipments);

    ShipmentLocationResponse toLocationResponse(Factory factory);

    ShipmentLocationResponse toLocationResponse(Store store);
}

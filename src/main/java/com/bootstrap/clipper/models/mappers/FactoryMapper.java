package com.bootstrap.clipper.models.mappers;

import com.bootstrap.clipper.models.dao.Factory;
import com.bootstrap.clipper.models.dto.FactoryRequest;
import com.bootstrap.clipper.models.dto.FactoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stock", ignore = true)
    @Mapping(target = "latitude", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    @Mapping(target = "version", ignore = true)
    Factory toEntity(FactoryRequest request);

    FactoryResponse toResponse(Factory factory);

    List<FactoryResponse> toResponseList(List<Factory> factories);
}

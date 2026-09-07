package com.bootstrap.clipper.models.mappers;

import com.bootstrap.clipper.models.dao.Store;
import com.bootstrap.clipper.models.dto.StoreRequest;
import com.bootstrap.clipper.models.dto.StoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stock", ignore = true)
    @Mapping(target = "latitude", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    @Mapping(target = "version", ignore = true)
    Store toEntity(StoreRequest request);

    StoreResponse toResponse(Store store);

    List<StoreResponse> toResponseList(List<Store> stores);
}

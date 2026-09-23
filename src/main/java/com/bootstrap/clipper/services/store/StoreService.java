package com.bootstrap.clipper.services.store;

import com.bootstrap.clipper.models.dao.Shipment;
import com.bootstrap.clipper.models.dao.Store;
import com.bootstrap.clipper.models.dto.FactoryAvailabilityResponse;

import java.util.List;

public interface StoreService {
    Store saveStore(Store store);
    Store updateStore(Long storeId, Store store);
    Store patchStore(Long storeId, Store store);
    Store getStore(Long storeId);
    Store purchase(Long storeId, int quantity);
    List<Store> getAllStores();
    void deleteStore(Long storeId);
    List<FactoryAvailabilityResponse> getAvailableFactories(Long storeId);
    Shipment supplyStore(Long storeId, Long factoryId, int quantity);
    List<Shipment> getShipments(Long storeId, String status);
}

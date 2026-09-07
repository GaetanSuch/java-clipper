package com.bootstrap.clipper.services.factory;

import com.bootstrap.clipper.models.dao.Factory;

import java.util.List;

public interface FactoryService {
    Factory saveFactory(Factory request);
    Factory updateFactory(Long factoryId, Factory request);
    Factory patchFactory(Long factoryId, Factory request);
    Factory getFactory(Long factoryId);
    List<Factory> getAllFactory();
    void deleteFactory(Long factoryId);
    Factory produceFactory(Long factoryId, int quantity);
}

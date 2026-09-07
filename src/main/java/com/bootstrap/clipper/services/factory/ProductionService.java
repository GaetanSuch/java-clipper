package com.bootstrap.clipper.services.factory;

import com.bootstrap.clipper.repositories.FactoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductionService {

    private final FactoryRepository repository;

    @Scheduled(fixedRate = 5000)
    @Transactional
    public void produceClips() {
        var factories = repository.findAll();
        for (var factory : factories) {
            factory.produce();
            log.info("Usine '{}' +{} trombones (stock: {})",
                    factory.getName(), factory.getProduction(), factory.getStock());
        }
        repository.saveAll(factories);
    }
}

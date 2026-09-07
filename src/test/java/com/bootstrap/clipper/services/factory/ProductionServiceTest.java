package com.bootstrap.clipper.services.factory;

import com.bootstrap.clipper.models.dao.Factory;
import com.bootstrap.clipper.repositories.FactoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductionServiceTest {

    @Mock
    private FactoryRepository repository;

    @InjectMocks
    private ProductionService productionService;

    // ──── Tests sur Factory.produce() (logique métier pure) ────

    @Test
    void produce_shouldAddProductionToStock() {
        Factory factory = Factory.builder().name("Paris").production(10).build();

        factory.produce();

        assertEquals(10, factory.getStock());
    }

    @Test
    void produce_calledThreeTimes_shouldAccumulateStock() {
        Factory factory = Factory.builder().name("Lyon").production(5).build();

        factory.produce();
        factory.produce();
        factory.produce();

        assertEquals(15, factory.getStock());
    }

    @Test
    void produce_withExistingStock_shouldAddOnTop() {
        Factory factory = Factory.builder().name("Marseille").production(7).stock(20).build();

        factory.produce();

        assertEquals(27, factory.getStock());
    }

    // ──── Tests sur ProductionService.produceClips() (avec mock) ────

    @Test
    void produceClips_shouldCallProduceOnEachFactory() {
        Factory paris = Factory.builder().name("Paris").production(10).build();
        Factory lyon = Factory.builder().name("Lyon").production(5).build();
        when(repository.findAll()).thenReturn(List.of(paris, lyon));

        productionService.produceClips();

        assertEquals(10, paris.getStock());
        assertEquals(5, lyon.getStock());
        verify(repository).saveAll(List.of(paris, lyon));
    }

    @Test
    void produceClips_calledTwice_shouldDoubleProduction() {
        Factory factory = Factory.builder().name("Paris").production(8).build();
        when(repository.findAll()).thenReturn(List.of(factory));

        productionService.produceClips();
        productionService.produceClips();

        assertEquals(16, factory.getStock());
        verify(repository, times(2)).saveAll(List.of(factory));
    }

    @Test
    void produceClips_withNoFactory_shouldDoNothing() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        productionService.produceClips();

        verify(repository).saveAll(Collections.emptyList());
    }
}

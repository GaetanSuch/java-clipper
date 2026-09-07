package com.bootstrap.clipper.repositories;

import com.bootstrap.clipper.models.dao.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Long> {
}

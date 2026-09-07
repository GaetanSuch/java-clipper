package com.bootstrap.clipper.repositories;

import com.bootstrap.clipper.models.dao.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}

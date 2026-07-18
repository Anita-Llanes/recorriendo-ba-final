package com.recorriendoba.tours.repository;

import com.recorriendoba.tours.model.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface TourRepository extends JpaRepository<TourEntity, Integer> {
    Optional<TourEntity> findByName(String name);
}

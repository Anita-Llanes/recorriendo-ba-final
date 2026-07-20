package com.recorriendoba.tours.repository;

import com.recorriendoba.tours.model.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {
}
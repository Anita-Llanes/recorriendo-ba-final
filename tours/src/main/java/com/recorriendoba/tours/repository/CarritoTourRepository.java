package com.recorriendoba.tours.repository;

import com.recorriendoba.tours.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoTourRepository extends JpaRepository<CarritoTour, Integer> {
    
}

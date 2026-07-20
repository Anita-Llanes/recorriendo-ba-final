package com.recorriendoba.tours.repository;

import com.recorriendoba.tours.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    
}
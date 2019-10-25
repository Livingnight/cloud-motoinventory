package com.nadine.and.jay.cloudmotoinventory.repository;

import com.nadine.and.jay.cloudmotoinventory.dto.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {
}

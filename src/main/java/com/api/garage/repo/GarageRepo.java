package com.api.garage.repo;

import com.api.garage.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepo extends JpaRepository<Garage, Long>{
    boolean existsById(Long id);
}

package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.bbd.pointscalculator.model.pointsDTO;

public interface PointsRepository extends JpaRepository<pointsDTO, Long>{
    
}

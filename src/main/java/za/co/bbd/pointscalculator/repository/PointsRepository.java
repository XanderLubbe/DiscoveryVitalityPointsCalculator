package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import za.co.bbd.pointscalculator.model.PointsDTO;

import java.util.List;

public interface PointsRepository extends CrudRepository<PointsDTO, Long>{

    @Query ("SELECT t FROM VITALITY_POINTS t")
    List<PointsDTO> getAllPoints();
    
}

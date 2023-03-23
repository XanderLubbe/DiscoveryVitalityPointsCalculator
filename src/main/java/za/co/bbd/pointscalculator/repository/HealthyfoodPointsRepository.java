package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import za.co.bbd.pointscalculator.model.FitnessPointsDTO;

import java.util.List;

public interface HealthyfoodPointsRepository extends CrudRepository<FitnessPointsDTO, Long>{
    // change your query to what you need to query. Look at JPQL not SQL
    // create a function to fetch your data

    @Query ("SELECT t FROM FITNESS_POINTS t")
    List<FitnessPointsDTO> getAllPoints();
    
}

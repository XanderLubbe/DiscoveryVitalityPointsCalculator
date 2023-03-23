package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import za.co.bbd.pointscalculator.model.HealthyfoodDTO;

public interface HealthyfoodPointsRepository extends CrudRepository<HealthyfoodDTO, Long>{
    // change your query to what you need to query. Look at JPQL not SQL
    // create a function to fetch your data

    @Query("SELECT t FROM HEALTHY_FOODS t WHERE t.lowerLimit <= :healthyFoodPerMonth AND t.upperLimit >= :healthyFoodPerMonth")
    HealthyfoodDTO findFoodPerMonth(@Param("healthyFoodPerMonth") int healthyFoodPerMonth);
    
}

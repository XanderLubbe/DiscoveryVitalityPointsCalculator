package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import za.co.bbd.pointscalculator.model.HealthChecksDTO;

import java.util.List;

public interface HealthChecksPointsRepository extends CrudRepository<HealthChecksDTO, Long> {
    // change your query to what you need to query. Look at JPQL not SQL
    // create a function to fetch your data

    @Query("SELECT t FROM HEALTH_CHECK t")
    List<HealthChecksDTO> getAllPoints();
    // TODO: Match this with the Fitness Example

    @Query("SELECT t FROM HEALTH_CHECK t WHERE LOWER(t.check) = Lower(check)")
    HealthChecksDTO getCheckPoints(@Param("check") String check);

    // FitnessPointsDTO getActivityPoints(@Param("activity") String activity);

}

package za.co.bbd.pointscalculator.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import za.co.bbd.pointscalculator.model.BandsDTO;
import za.co.bbd.pointscalculator.model.FitnessPointsDTO;

import java.util.List;

public interface BandsRepository extends CrudRepository<BandsDTO, Long>{
    @Query("SELECT t FROM VITALITY_BANDS t WHERE t.lowerLimit <= :points AND t.upperLimit >= :points")
    BandsDTO findVitalityBand(@Param("points") int points);
    
}

package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.HealthyfoodDTO;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.repository.HealthyfoodPointsRepository;

@Service
public class HealthyFoodsService {

    private final HealthyfoodPointsRepository repository;
    private final int dietitianPoints ;

    HealthyFoodsService(HealthyfoodPointsRepository repository)
    {
        this.repository = repository;
        this.dietitianPoints = 1000;
    }

    public ResponsePoints findFoodPointsService(RequestHealthyFoods healthyFoodsRequest){
        HealthyfoodDTO repoFoods = repository.findFoodPerMonth(healthyFoodsRequest.getHealthyFoodSpend());
        int returnedDietitianPoints = this.dietitianPoints;
        int returnedFoodPoints = repoFoods.getPoints();
        return new ResponsePoints(returnedFoodPoints + returnedDietitianPoints);
    }
}

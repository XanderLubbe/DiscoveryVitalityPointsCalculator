package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.HealthyFoods;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class HealthyFoodsService {

    private final PointsObjectRepository repository;

    HealthyFoodsService(PointsObjectRepository repository){this.repository = repository;}

    public ResponsePoints findFoodPointsService(RequestHealthyFoods healthyFoodsRequest){
        HealthyFoods repoFoods = repository.findFoodPoints(healthyFoodsRequest.isVisitedDietician(), healthyFoodsRequest.getHealthyFoodSpend());
        int returnedDietitianPoints = repoFoods.dietitianPoints();
        int returnedFoodPoints = repoFoods.foodPoints();
        return new ResponsePoints(returnedFoodPoints + returnedDietitianPoints);
    }
}

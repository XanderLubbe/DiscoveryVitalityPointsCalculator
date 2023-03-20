package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.HealthyFoods;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class HealthyFoodsService {

    private final PointsObjectRepository repository;

    HealthyFoodsService(PointsObjectRepository repository){this.repository = repository;}

    public int findFoodPointsService(boolean dietitianVisit, int healthyFoodPerMonth){
        HealthyFoods repoFoods = repository.findFoodPoints(dietitianVisit, healthyFoodPerMonth);
        int returnedDietitianPoints = repoFoods.dietitianPoints();
        int returnedFoodPoints = repoFoods.foodPoints();
        return returnedFoodPoints + returnedDietitianPoints;
    }
}

package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;

@Service
public class AggregatorService {

    private HealthyFoodsService healthyFoodService;
    // private HealthAssesmentService healthAssesmentService;
    // private FitnessService fitnessService;
    private VitalityBandService vitalityBandService;


    AggregatorService(HealthyFoodsService healthyFoodService, VitalityBandService vitalityBandService){
        this.healthyFoodService = healthyFoodService;
        this.vitalityBandService = vitalityBandService;
    }

    public String getVitalityBandService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness) {
        ResponsePoints totalPoints = getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness);
        int result = totalPoints.getPoints();
        String bandResult = vitalityBandService.getBand(result);

        return bandResult;
        
    }

    public ResponsePoints getTotalVitalityPointsService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        ResponsePoints foodPoints = healthyFoodService.findFoodPointsService(requestHealthyFoods.isVisitedDietician(), requestHealthyFoods.getHealthyFoodSpend());
        // ResponsePoints fitnessPoints = fitnessService.calculateFitnessPoints(requestFitness);
        int result = foodPoints.getPoints();

        return new ResponsePoints(result);
    }
}

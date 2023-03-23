package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;

@Service
public class AggregatorService {

    private HealthyFoodsService healthyFoodService;
     private HealthCheckService healthCheckService;
    private FitnessService fitnessService;
    private VitalityBandService vitalityBandService;


    AggregatorService(HealthyFoodsService healthyFoodService, VitalityBandService vitalityBandService, FitnessService fitnessService, HealthCheckService healthCheckService){
        this.healthyFoodService = healthyFoodService;
        this.vitalityBandService = vitalityBandService;
        this.fitnessService = fitnessService;
        this.healthCheckService = healthCheckService;
    }

    public String getVitalityBandService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness) {
        ResponsePoints totalPoints = getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness);
        int result = totalPoints.getPoints();
        String bandResult = vitalityBandService.getBand(result);

        return bandResult;
        
    }

    public ResponsePoints getTotalVitalityPointsService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        ResponsePoints foodPoints = healthyFoodService.findFoodPointsService(requestHealthyFoods.isVisitedDietician(), requestHealthyFoods.getHealthyFoodSpend());
        ResponsePoints fitnessPoints = fitnessService.calculateFitnessPoints(requestFitness) ;
//        ResponsePoints healthCheckPoints = healthCheckService.findHealthCheckPointsService();
        int result = foodPoints.getPoints() + fitnessPoints.getPoints();

        return new ResponsePoints(result);
    }
}

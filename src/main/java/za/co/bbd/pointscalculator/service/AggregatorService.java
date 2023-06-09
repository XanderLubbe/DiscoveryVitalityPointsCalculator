package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.*;
import za.co.bbd.pointscalculator.repository.FitnessPointsRepository;

@Service
public class AggregatorService {

    private HealthyFoodsService healthyFoodService;
    private HealthCheckService healthCheckService;
    private FitnessService fitnessService;
    private VitalityBandService vitalityBandService;
    private FitnessPointsRepository repository;

    AggregatorService(FitnessPointsRepository repository, HealthyFoodsService healthyFoodService,
            VitalityBandService vitalityBandService, FitnessService fitnessService,
            HealthCheckService healthCheckService) {
        this.healthyFoodService = healthyFoodService;
        this.fitnessService = fitnessService;
        this.healthCheckService = healthCheckService;
        this.vitalityBandService = vitalityBandService;
        this.repository = repository;
    }

    public String getVitalityBandService(RequestHealthyFoods requestHealthyFoods,
            RequestHealthChecks requestHealthChecks, RequestFitness requestFitness) {
        ResponsePoints totalPoints = getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks,
                requestFitness);
        int result = totalPoints.points();
        String bandResult = vitalityBandService.getBand(result);

        return bandResult;

    }

    public ResponsePoints getTotalVitalityPointsService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        ResponsePoints foodPoints = healthyFoodService.findFoodPointsService(requestHealthyFoods);
        ResponsePoints fitnessPoints = fitnessService.calculateFitnessPoints(requestFitness);
        ResponsePoints healthCheckPoints = healthCheckService.findHealthCheckPointsService(requestHealthChecks);
        int result = foodPoints.points() + fitnessPoints.points() + healthCheckPoints.points();

        return new ResponsePoints(result);
    }
}

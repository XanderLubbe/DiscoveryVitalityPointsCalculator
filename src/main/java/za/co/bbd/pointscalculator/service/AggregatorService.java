package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import za.co.bbd.pointscalculator.model.*;
import za.co.bbd.pointscalculator.repository.PointsRepository;

@Service
public class AggregatorService {

    private HealthyFoodsService healthyFoodService;
     private HealthCheckService healthCheckService;
    private FitnessService fitnessService;
    private VitalityBandService vitalityBandService;
    private PointsRepository repository;


    AggregatorService(PointsRepository repository, HealthyFoodsService healthyFoodService, VitalityBandService vitalityBandService, FitnessService fitnessService, HealthCheckService healthCheckService){
        this.healthyFoodService = healthyFoodService;
        this.vitalityBandService = vitalityBandService;
        this.fitnessService = fitnessService;
//        this.healthCheckService = healthCheckService;
        this.repository = repository;
    }

    public String getVitalityBandService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness) {
        ResponsePoints totalPoints = getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness);
        int result = totalPoints.getPoints();
        String bandResult = vitalityBandService.getBand(result);

        return bandResult;
        
    }

    public ResponsePoints getTotalVitalityPointsService(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        List<PointsDTO> repoPointsDTO = repository.getAllPoints();
        //        List<PointsDTO> databaseResponse = PointsRepository
        System.out.println(repoPointsDTO.get(2).getActivity());
        ResponsePoints foodPoints = healthyFoodService.findFoodPointsService(requestHealthyFoods);
        ResponsePoints fitnessPoints = fitnessService.calculateFitnessPoints(requestFitness) ;
//        ResponsePoints healthCheckPoints = healthCheckService.findHealthCheckPointsService();
        int result = foodPoints.getPoints() + fitnessPoints.getPoints();

        return new ResponsePoints(result);
    }
}

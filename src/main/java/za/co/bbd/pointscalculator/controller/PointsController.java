package za.co.bbd.pointscalculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import za.co.bbd.pointscalculator.model.*;
import za.co.bbd.pointscalculator.repository.BandsRepository;
import za.co.bbd.pointscalculator.service.FitnessService;
import za.co.bbd.pointscalculator.service.HealthyFoodsService;
import za.co.bbd.pointscalculator.service.AggregatorService;
import za.co.bbd.pointscalculator.service.HealthCheckService;

@RestController
@RequestMapping("/vitality")
public class PointsController{

    private final HealthCheckService healthService;
    private final HealthyFoodsService foodService;
    private final FitnessService fitnessService;
    private final BandsRepository bandsRepository;
    private final AggregatorService aggregatorService;


    PointsController( HealthCheckService healthService, HealthyFoodsService foodService, FitnessService fitnessService, BandsRepository bandsRepository, AggregatorService service){
        this.healthService = healthService;
        this.foodService = foodService;
        this.fitnessService = fitnessService;
        this.bandsRepository = bandsRepository;
        this.aggregatorService = service;
    }

    @GetMapping("/points")
    List<ResponsePoints> points(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        String bandResult = bandsRepository.findVitalityBand(40000).getBand();
        System.out.println(bandResult);
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(aggregatorService.getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));

        return result;
    }

    @GetMapping("/points/healthyfoods")
    ResponsePoints findFoodPoints( RequestHealthyFoods healthyFoodsRequest) {
        return foodService.findFoodPointsService(healthyFoodsRequest);
    }

    @GetMapping("/points/fitness")
    ResponsePoints getFitnessPoints( RequestFitness requestFitness){
        return fitnessService.calculateFitnessPoints(requestFitness);
    }

    //To test HealthCheck service
    @GetMapping("/healthCheck")
    ResponsePoints findHealthPoints(    @RequestParam 
                                        boolean vitalityAge,
                                        int mentalWellbeing,
                                        int golfPlayed,
                                        boolean fluVaccine,
                                        boolean initialHIVTest,
                                        boolean annualHIVTest,
                                        boolean papSmear,
                                        boolean mammogram,
                                        boolean colonoscopy,
                                        boolean dentalCheck,
                                        boolean glaucomaScreening,
                                        boolean managingChronicCondition,
                                        boolean bloodPressure,
                                        boolean bloodGlucose,
                                        boolean cholestrol,
                                        boolean weightAssesment,
                                        boolean nonSmokersDeclaration ){
        return healthService.findHealthCheckPointsService(  vitalityAge,
                                                             mentalWellbeing,
                                                             golfPlayed,
                                                             fluVaccine,
                                                             initialHIVTest,
                                                             annualHIVTest,
                                                             papSmear,
                                                             mammogram,
                                                             colonoscopy,
                                                             dentalCheck,
                                                             glaucomaScreening,
                                                             managingChronicCondition,
                                                             bloodPressure,
                                                             bloodGlucose,
                                                             cholestrol,
                                                             weightAssesment,
                                                             nonSmokersDeclaration);
    }



    @GetMapping("/bands")
    String bands(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        String result = (aggregatorService.getVitalityBandService(requestHealthyFoods, requestHealthChecks, requestFitness));

        return result;
    }

}

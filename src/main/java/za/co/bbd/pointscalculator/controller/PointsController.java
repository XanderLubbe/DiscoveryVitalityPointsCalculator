package za.co.bbd.pointscalculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.service.FitnessService;
import za.co.bbd.pointscalculator.service.HealthyFoodsService;
import za.co.bbd.pointscalculator.service.AggregatorService;
import za.co.bbd.pointscalculator.service.HealthCheckService;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;

@RestController
@RequestMapping("/vitality")
public class PointsController {

    private final HealthCheckService healthService;
    private final HealthyFoodsService foodService;
    private final AggregatorService service;
    private final FitnessService fitnessService;

    PointsController(AggregatorService service, HealthyFoodsService foodService, FitnessService fitnessService,
            HealthCheckService healthService) {
        this.service = service;
        this.foodService = foodService;
        this.fitnessService = fitnessService;
        this.healthService = healthService;

    }

    @GetMapping("/foodPoints")
    ResponsePoints findFoodPoints(@RequestParam RequestHealthyFoods healthyFoodsRequest) {

        return foodService.findFoodPointsService(healthyFoodsRequest);
    }

    @GetMapping("/points/fitness")
    ResponsePoints getFitnessPoints(RequestFitness requestFitness) {
        return fitnessService.calculateFitnessPoints(requestFitness);
    }

    // To test HealthCheck service
    @GetMapping("/healthCheck")
    ResponsePoints findHealthPoints(RequestHealthChecks requestHealthChecks) {
        return healthService.findHealthCheckPointsService(requestHealthChecks);
    }

    // this works by binding query params to objects
    @GetMapping("/testObject")
    List<ResponsePoints> requestPoints(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks,
            RequestFitness requestFitness) {
        System.out.println(requestHealthyFoods.isVisitedDietician());
        System.out.println(requestHealthyFoods.getHealthyFoodSpend());
        System.out.println(requestHealthChecks.isBloodGlucose());
        System.out.println(requestFitness.getCyclingRaceEventLevel1());

        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));

        return result;
    }

    @GetMapping("/points")
    List<ResponsePoints> points(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks,
            RequestFitness requestFitness) {
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Congratulations you have %s points!", result));

        return result;
    }

    @GetMapping("/bands")
    String bands(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks,
            RequestFitness requestFitness) {
        String result = (service.getVitalityBandService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Hello you are on the %s band!", result));

        return result;
    }

}

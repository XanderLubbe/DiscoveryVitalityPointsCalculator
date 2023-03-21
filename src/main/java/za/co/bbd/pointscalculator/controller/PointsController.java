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

@RestController
@RequestMapping("/vitality")
public class PointsController{

    private final HealthyFoodsService foodService;
    private final AggregatorService service;
    private final FitnessService fitnessService;

    PointsController(AggregatorService service, HealthyFoodsService foodService, FitnessService fitnessService){
        this.service = service;
        this.foodService = foodService;
        this.fitnessService = fitnessService;
    }

    @GetMapping("/foodPoints")
    ResponsePoints findFoodPoints(@RequestParam boolean dietitianVisit, int healthyFoodPerMonth) {

        return foodService.findFoodPointsService(dietitianVisit, healthyFoodPerMonth);
    }

    @GetMapping("/fitnessPoints")
    ResponsePoints findFitnessPoints(@RequestParam int walking5000PlusSteps,
                          int walking10000PlusSteps,
                          int onlineWorkout,
                          int speedWorkout,
                          int lightWorkout,
                          int moderateWorkout30Min,
                          int moderateWorkout60Min,
                          int vigorousWorkout,
                          int parkrun,
                          int walkingOrRunningRaceEventLevel1,
                          int walkingOrRunningRaceEventLevel2,
                          int walkingOrRunningRaceEventLevel3,
                          int walkingOrRunningRaceEventLevel4,
                          int swimmingRaceEventLevel1,
                          int swimmingRaceEventLevel2,
                          int swimmingRaceEventLevel3,
                          int swimmingRaceEventLevel4,
                          int cyclingRaceEventLevel1,
                          int cyclingRaceEventLevel2,
                          int cyclingRaceEventLevel3,
                          int cyclingRaceEventLevel4) {

        return fitnessService.calculateFitnessPoints(new RequestFitness(walking5000PlusSteps,
                walking10000PlusSteps,
                onlineWorkout,
                speedWorkout,
                lightWorkout,
                moderateWorkout30Min,
                moderateWorkout60Min,
                vigorousWorkout,
                parkrun,
                walkingOrRunningRaceEventLevel1,
                walkingOrRunningRaceEventLevel2,
                walkingOrRunningRaceEventLevel3,
                walkingOrRunningRaceEventLevel4,
                swimmingRaceEventLevel1,
                swimmingRaceEventLevel2,
                swimmingRaceEventLevel3,
                swimmingRaceEventLevel4,
                cyclingRaceEventLevel1,
                cyclingRaceEventLevel2,
                cyclingRaceEventLevel3,
                cyclingRaceEventLevel4));
    }

    @GetMapping("/fitnessPoints2")
    ResponsePoints getFitnessPoints(@RequestBody RequestFitness requestFitness){
        return fitnessService.calculateFitnessPoints(requestFitness);
    }

    // this works by binding query params to objects 
    @GetMapping("/testObject")
    List<ResponsePoints> requestPoints(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        System.out.println(requestHealthyFoods.isVisitedDietician());
        System.out.println(requestHealthyFoods.getHealthyFoodSpend());
        System.out.println(requestHealthChecks.isBloodGlucose());
        System.out.println(requestFitness.getCyclingRaceEventLevel1());
  
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));

        return result;
    }

    @GetMapping("/points")
    List<ResponsePoints> points(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getTotalVitalityPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Congratulations you have %s points!", result)); 

        return result;
    }

    @GetMapping("/bands")
    String bands(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        String result = (service.getVitalityBandService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Hello you are on the %s band!", result)); 

        return result;
    }

}

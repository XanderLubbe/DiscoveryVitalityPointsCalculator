package za.co.bbd.pointscalculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.model.RequestHealthyFoods;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.service.HealthyFoodsService;
import za.co.bbd.pointscalculator.service.HealthCheckService;
import za.co.bbd.pointscalculator.service.testService;

@RestController
@RequestMapping("/vitality")
public class PointsController{

    private final HealthCheckService healthService;
    private final HealthyFoodsService foodService;
    private final testService service;

    PointsController(testService service, HealthyFoodsService foodService, HealthCheckService healthService){
        this.service = service;
        this.foodService = foodService;
        this.healthService = healthService;


    }

    @GetMapping("/foodPoints")
    ResponsePoints findFoodPoints(@RequestParam boolean dietitianVisit, int healthyFoodPerMonth) {

        return foodService.findFoodPointsService(dietitianVisit, healthyFoodPerMonth);
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


    // this works by binding query params to objects 
    @GetMapping("/testObject")
    List<ResponsePoints> requestPoints(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        System.out.println(requestHealthyFoods.isVisitedDietician());
        System.out.println(requestHealthyFoods.getHealthyFoodSpend());
        System.out.println(requestHealthChecks.isBloodGlucose());
        System.out.println(requestFitness.getCyclingRaceEventLevel1());
  
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));
        return result;
    }

    @GetMapping("/points")
    List<ResponsePoints> points(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Congratulations you have %s points!", result)); 
        return result;
    }

    @GetMapping("/bands")
    List<ResponsePoints> bands(RequestHealthyFoods requestHealthyFoods, RequestHealthChecks requestHealthChecks, RequestFitness requestFitness){
        List<ResponsePoints> result = new ArrayList<ResponsePoints>();
        result.add(service.getPointsService(requestHealthyFoods, requestHealthChecks, requestFitness));
        System.out.println(String.format("Hello you are on the %s band!", result)); 
        return result;
    }

}

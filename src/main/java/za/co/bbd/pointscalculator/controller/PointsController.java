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
import za.co.bbd.pointscalculator.service.AggregatorService;

@RestController
@RequestMapping("/vitality")
public class PointsController{

    private final HealthyFoodsService foodService;
    private final AggregatorService service;

    PointsController(AggregatorService service, HealthyFoodsService foodService ){
        this.service = service;
        this.foodService = foodService;
    }

    @GetMapping("/foodPoints")
    ResponsePoints findFoodPoints(@RequestParam boolean dietitianVisit, int healthyFoodPerMonth) {

        return foodService.findFoodPointsService(dietitianVisit, healthyFoodPerMonth);
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

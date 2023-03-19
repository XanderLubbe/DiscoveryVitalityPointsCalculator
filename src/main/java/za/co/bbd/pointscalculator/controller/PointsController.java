package za.co.bbd.pointscalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.bbd.pointscalculator.model.TestModel;
import za.co.bbd.pointscalculator.service.HealthyFoodsService;
import za.co.bbd.pointscalculator.service.testService;

@RestController

public class PointsController{

    private final HealthyFoodsService foodService;
    private final testService service;

    PointsController(testService service, HealthyFoodsService foodService ){
        this.service = service;
        this.foodService = foodService;

    }

    @GetMapping("/foodPoints")
    int findFoodPoints(@RequestParam boolean dietitianVisit, int healthyFoodPerMonth) {

        return foodService.findFoodPointsService(dietitianVisit, healthyFoodPerMonth);
    }

    @GetMapping("/vitality/test")
    TestModel getPoints(@RequestParam String activity){
        return service.getPointsService(activity);
    }

    @GetMapping("/vitality/points")
    public String points(@RequestParam(value = "name", defaultValue = "13 591 points") String points) {
        return String.format("Hello you have %s!", points);
    }

    @GetMapping("/vitality/bands")
    public String bands(@RequestParam(value = "name", defaultValue = "Silver") String bands) {
        return String.format("Hello you are on the %s band!", bands);
    }

}

package za.co.bbd.pointscalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.bbd.pointscalculator.services.HealthyFoodsService;

@RestController
public class PointsController {

    private final HealthyFoodsService foodService;

    PointsController(HealthyFoodsService service){this.foodService = service;}

    @GetMapping("/foodPoints")
    int findFoodPoints(@RequestParam boolean dietitianVisit, int healthyFoodPerMonth) {

        return foodService.findFoodPointsService(dietitianVisit, healthyFoodPerMonth);
    }

}

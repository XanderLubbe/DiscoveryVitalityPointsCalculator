package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


public record RequestHealthyFoods (

    boolean visitedDietician,
    int healthyFoodSpend

){}

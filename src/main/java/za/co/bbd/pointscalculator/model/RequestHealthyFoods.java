package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestHealthyFoods {

    private final boolean visitedDietician;
    private final int healthyFoodSpend;
    
}

package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class RequestHealthyFoods {

    private final boolean visitedDietician;
    private final int healthyFoodSpend;

    public RequestHealthyFoods(boolean visitedDietician, int healthyfoodSpend){
        this.visitedDietician = visitedDietician;
        this.healthyFoodSpend = healthyfoodSpend;
    }
    
}

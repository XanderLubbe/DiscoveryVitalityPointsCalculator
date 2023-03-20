package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class ResponsePoints {
    private final boolean visitedDietician;
    private final int healthyFoodSpend;
    private final boolean firstHIVTest;
    private final boolean bloodGlucose;
    private final int cyclingRaceEventOption1;
    



    public ResponsePoints(boolean visitedDietician, int healthyfoodSpend, boolean firstHIVTest, boolean bloodGlucose, int cyclingRaceEventOption1){
        this.visitedDietician = visitedDietician;
        this.healthyFoodSpend = healthyfoodSpend;
        this.firstHIVTest = firstHIVTest;
        this.bloodGlucose = bloodGlucose;
        this.cyclingRaceEventOption1 = cyclingRaceEventOption1;


    }
}

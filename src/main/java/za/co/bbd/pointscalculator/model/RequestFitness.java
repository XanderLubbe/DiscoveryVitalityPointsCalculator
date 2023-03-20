package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class RequestFitness {
    
    // General fitness activities
    private int walking5000PlusSteps;
    private int walking10000PlusSteps;
    private int onlineWorkout;
    private int speedWorkout;
    private int lightWorkout;
    private int moderateWorkout30Min;
    private int moderateWorkout60Min;
    private int vigorousWorkout;
    private int parkrun;

    // Race Events
    private int walkingOrRunningRaceEventOption1;
    private int walkingOrRunningRaceEventOption2;
    private int walkingOrRunningRaceEventOption3;
    private int walkingOrRunningRaceEventOption4;
    private int swimmingRaceEventOption1;
    private int swimmingRaceEventOption2;
    private int swimmingRaceEventOption3;
    private int swimmingRaceEventOption4;
    private int cyclingRaceEventOption1;
    private int cyclingRaceEventOption2;
    private int cyclingRaceEventOption3;
    private int cyclingRaceEventOption4;

    public RequestFitness(int cyclingRaceEventOption1){
        this.cyclingRaceEventOption1 = cyclingRaceEventOption1;
    }
    
}

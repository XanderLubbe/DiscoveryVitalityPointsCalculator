package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
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
    private int walkingOrRunningRaceEventLevel1;
    private int walkingOrRunningRaceEventLevel2;
    private int walkingOrRunningRaceEventLevel3;
    private int walkingOrRunningRaceEventLevel4;

    private int swimmingRaceEventLevel1;
    private int swimmingRaceEventLevel2;
    private int swimmingRaceEventLevel3;
    private int swimmingRaceEventLevel4;

    private int cyclingRaceEventLevel1;
    private int cyclingRaceEventLevel2;
    private int cyclingRaceEventLevel3;
    private int cyclingRaceEventLevel4;

    // public RequestFitness(int cyclingRaceEventLevel1){
    //     this.cyclingRaceEventLevel1 = cyclingRaceEventLevel1;
    // }
    
}

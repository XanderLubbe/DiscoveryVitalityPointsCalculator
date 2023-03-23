package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record RequestFitness (

    int walking5000PlusSteps,
    int walking10000PlusSteps,
    int onlineWorkout,
    int speedWorkout,
    int lightWorkout,
    int moderateWorkout30Min,
    int moderateWorkout60Min,
    int vigorousWorkout,
    int parkrun,

    int walkingOrRunningRaceEventLevel1,
    int walkingOrRunningRaceEventLevel2,
    int walkingOrRunningRaceEventLevel3,
    int walkingOrRunningRaceEventLevel4,

    int swimmingRaceEventLevel1,
    int swimmingRaceEventLevel2,
    int swimmingRaceEventLevel3,
    int swimmingRaceEventLevel4,

    int cyclingRaceEventLevel1,
    int cyclingRaceEventLevel2,
    int cyclingRaceEventLevel3,
    int cyclingRaceEventLevel4

){}

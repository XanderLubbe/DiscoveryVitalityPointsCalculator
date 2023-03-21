package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class FitnessService {

    private final PointsObjectRepository repository;

    public FitnessService(PointsObjectRepository repository) {
        this.repository = repository;
    }

    public ResponsePoints calculateFitnessPoints(RequestFitness requestFitness){
        int walking1 = requestFitness.getWalking5000PlusSteps() * repository.getActivityPoints(1);
        int walking2 = requestFitness.getWalking10000PlusSteps() * repository.getActivityPoints(2);
        int onlineWorkout = requestFitness.getOnlineWorkout() * repository.getActivityPoints(3);
        int speedWorkout = requestFitness.getSpeedWorkout() * repository.getActivityPoints(4);
        int lightWorkout = requestFitness.getLightWorkout() * repository.getActivityPoints(5);
        int moderateWorkout1 = requestFitness.getModerateWorkout30Min() * repository.getActivityPoints(6);
        int moderateWorkout2 = requestFitness.getModerateWorkout60Min() * repository.getActivityPoints(7);
        int vigorousWorkout = requestFitness.getVigorousWorkout() * repository.getActivityPoints(8);
        int parkrun = requestFitness.getParkrun() * repository.getActivityPoints(9);
        int walkrun1 = requestFitness.getWalkingOrRunningRaceEventLevel1() * repository.getActivityPoints(10);
        int walkrun2 = requestFitness.getWalkingOrRunningRaceEventLevel2() * repository.getActivityPoints(11);
        int walkrun3 = requestFitness.getWalkingOrRunningRaceEventLevel3() * repository.getActivityPoints(12);
        int walkrun4 = requestFitness.getWalkingOrRunningRaceEventLevel4() * repository.getActivityPoints(13);
        int swimming1= requestFitness.getSwimmingRaceEventLevel1() * repository.getActivityPoints(14);
        int swimming2 = requestFitness.getSwimmingRaceEventLevel2() * repository.getActivityPoints(15);
        int swimming3 = requestFitness.getSwimmingRaceEventLevel3() * repository.getActivityPoints(16);
        int swimming4 = requestFitness.getSwimmingRaceEventLevel4() * repository.getActivityPoints(17);
        int cycling1= requestFitness.getCyclingRaceEventLevel1() * repository.getActivityPoints(18);
        int cycling2 = requestFitness.getCyclingRaceEventLevel1() * repository.getActivityPoints(19);
        int cycling3 = requestFitness.getCyclingRaceEventLevel1() * repository.getActivityPoints(20);
        int cycling4 = requestFitness.getCyclingRaceEventLevel1() * repository.getActivityPoints(21);
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }
}

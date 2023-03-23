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
        int walking1 = requestFitness.getWalking5000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+5000").getPoints();
        int walking2 = requestFitness.getWalking10000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+10000").getPoints();
        int onlineWorkout = requestFitness.getOnlineWorkout() * fitnessPointsRepository.getActivityPoints("OnlineWorkout").getPoints();
        int speedWorkout = requestFitness.getSpeedWorkout() * fitnessPointsRepository.getActivityPoints("SpeedWorkout").getPoints();
        int lightWorkout = requestFitness.getLightWorkout() * fitnessPointsRepository.getActivityPoints("LightWorkout").getPoints();
        int moderateWorkout1 = requestFitness.getModerateWorkout30Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout30Min").getPoints();
        int moderateWorkout2 = requestFitness.getModerateWorkout60Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout60Min").getPoints();
        int vigorousWorkout = requestFitness.getVigorousWorkout() * fitnessPointsRepository.getActivityPoints("VigorousWorkout").getPoints();
        int parkrun = requestFitness.getParkrun() * fitnessPointsRepository.getActivityPoints("ParkRun").getPoints();
        int walkrun1 = requestFitness.getWalkingOrRunningRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel1").getPoints();
        int walkrun2 = requestFitness.getWalkingOrRunningRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel2").getPoints();
        int walkrun3 = requestFitness.getWalkingOrRunningRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel3").getPoints();
        int walkrun4 = requestFitness.getWalkingOrRunningRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel4").getPoints();
        int swimming1= requestFitness.getSwimmingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel1").getPoints();
        int swimming2 = requestFitness.getSwimmingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel2").getPoints();
        int swimming3 = requestFitness.getSwimmingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel3").getPoints();
        int swimming4 = requestFitness.getSwimmingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel4").getPoints();
        int cycling1= requestFitness.getCyclingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel1").getPoints();
        int cycling2 = requestFitness.getCyclingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel2").getPoints();
        int cycling3 = requestFitness.getCyclingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel3").getPoints();
        int cycling4 = requestFitness.getCyclingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel4").getPoints();
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }
}

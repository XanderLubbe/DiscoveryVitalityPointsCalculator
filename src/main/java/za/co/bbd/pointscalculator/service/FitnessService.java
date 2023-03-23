package za.co.bbd.pointscalculator.service;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.RequestFitness;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.repository.FitnessPointsRepository;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class FitnessService {

    private final PointsObjectRepository repository;

    private final FitnessPointsRepository fitnessPointsRepository;

    public FitnessService(PointsObjectRepository repository, FitnessPointsRepository fitnessPointsRepository) {
        this.repository = repository;
        this.fitnessPointsRepository = fitnessPointsRepository;
    }

    public ResponsePoints calculateFitnessPoints(RequestFitness requestFitness){
        int walking1 = requestFitness.walking5000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+5000").points();
        int walking2 = requestFitness.walking10000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+10000").points();
        int onlineWorkout = requestFitness.onlineWorkout() * fitnessPointsRepository.getActivityPoints("OnlineWorkout").points();
        int speedWorkout = requestFitness.speedWorkout() * fitnessPointsRepository.getActivityPoints("SpeedWorkout").points();
        int lightWorkout = requestFitness.lightWorkout() * fitnessPointsRepository.getActivityPoints("LightWorkout").points();
        int moderateWorkout1 = requestFitness.moderateWorkout30Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout30Min").points();
        int moderateWorkout2 = requestFitness.moderateWorkout60Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout60Min").points();
        int vigorousWorkout = requestFitness.vigorousWorkout() * fitnessPointsRepository.getActivityPoints("VigorousWorkout").points();
        int parkrun = requestFitness.parkrun() * fitnessPointsRepository.getActivityPoints("ParkRun").points();
        int walkrun1 = requestFitness.walkingOrRunningRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel1").points();
        int walkrun2 = requestFitness.walkingOrRunningRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel2").points();
        int walkrun3 = requestFitness.walkingOrRunningRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel3").points();
        int walkrun4 = requestFitness.walkingOrRunningRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel4").points();
        int swimming1= requestFitness.swimmingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel1").points();
        int swimming2 = requestFitness.swimmingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel2").points();
        int swimming3 = requestFitness.swimmingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel3").points();
        int swimming4 = requestFitness.swimmingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel4").points();
        int cycling1= requestFitness.cyclingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel1").points();
        int cycling2 = requestFitness.cyclingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel2").points();
        int cycling3 = requestFitness.cyclingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel3").points();
        int cycling4 = requestFitness.cyclingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel4").points();
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }

    public ResponsePoints calculateFitnessPoints2(RequestFitness requestFitness){
        int walking1 = requestFitness.walking5000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+5000").points();
        int walking2 = requestFitness.walking10000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+10000").points();
        int onlineWorkout = requestFitness.onlineWorkout() * fitnessPointsRepository.getActivityPoints("OnlineWorkout").points();
        int speedWorkout = requestFitness.speedWorkout() * fitnessPointsRepository.getActivityPoints("SpeedWorkout").points();
        int lightWorkout = requestFitness.lightWorkout() * fitnessPointsRepository.getActivityPoints("LightWorkout").points();
        int moderateWorkout1 = requestFitness.moderateWorkout30Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout30Min").points();
        int moderateWorkout2 = requestFitness.moderateWorkout60Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout60Min").points();
        int vigorousWorkout = requestFitness.vigorousWorkout() * fitnessPointsRepository.getActivityPoints("VigorousWorkout").points();
        int parkrun = requestFitness.parkrun() * fitnessPointsRepository.getActivityPoints("ParkRun").points();
        int walkrun1 = requestFitness.walkingOrRunningRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel1").points();
        int walkrun2 = requestFitness.walkingOrRunningRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel2").points();
        int walkrun3 = requestFitness.walkingOrRunningRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel3").points();
        int walkrun4 = requestFitness.walkingOrRunningRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel4").points();
        int swimming1= requestFitness.swimmingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel1").points();
        int swimming2 = requestFitness.swimmingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel2").points();
        int swimming3 = requestFitness.swimmingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel3").points();
        int swimming4 = requestFitness.swimmingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel4").points();
        int cycling1= requestFitness.cyclingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel1").points();
        int cycling2 = requestFitness.cyclingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel2").points();
        int cycling3 = requestFitness.cyclingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel3").points();
        int cycling4 = requestFitness.cyclingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel4").points();
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }
}

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
        int walking1 = requestFitness.walking5000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+5000").getPoints();
        int walking2 = requestFitness.walking10000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+10000").getPoints();
        int onlineWorkout = requestFitness.onlineWorkout() * fitnessPointsRepository.getActivityPoints("OnlineWorkout").getPoints();
        int speedWorkout = requestFitness.speedWorkout() * fitnessPointsRepository.getActivityPoints("SpeedWorkout").getPoints();
        int lightWorkout = requestFitness.lightWorkout() * fitnessPointsRepository.getActivityPoints("LightWorkout").getPoints();
        int moderateWorkout1 = requestFitness.moderateWorkout30Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout30Min").getPoints();
        int moderateWorkout2 = requestFitness.moderateWorkout60Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout60Min").getPoints();
        int vigorousWorkout = requestFitness.vigorousWorkout() * fitnessPointsRepository.getActivityPoints("VigorousWorkout").getPoints();
        int parkrun = requestFitness.parkrun() * fitnessPointsRepository.getActivityPoints("ParkRun").getPoints();
        int walkrun1 = requestFitness.walkingOrRunningRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel1").getPoints();
        int walkrun2 = requestFitness.walkingOrRunningRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel2").getPoints();
        int walkrun3 = requestFitness.walkingOrRunningRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel3").getPoints();
        int walkrun4 = requestFitness.walkingOrRunningRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel4").getPoints();
        int swimming1= requestFitness.swimmingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel1").getPoints();
        int swimming2 = requestFitness.swimmingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel2").getPoints();
        int swimming3 = requestFitness.swimmingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel3").getPoints();
        int swimming4 = requestFitness.swimmingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel4").getPoints();
        int cycling1= requestFitness.cyclingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel1").getPoints();
        int cycling2 = requestFitness.cyclingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel2").getPoints();
        int cycling3 = requestFitness.cyclingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel3").getPoints();
        int cycling4 = requestFitness.cyclingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel4").getPoints();
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }

    public ResponsePoints calculateFitnessPoints2(RequestFitness requestFitness){
        int walking1 = requestFitness.walking5000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+5000").getPoints();
        int walking2 = requestFitness.walking10000PlusSteps() * fitnessPointsRepository.getActivityPoints("Walking+10000").getPoints();
        int onlineWorkout = requestFitness.onlineWorkout() * fitnessPointsRepository.getActivityPoints("OnlineWorkout").getPoints();
        int speedWorkout = requestFitness.speedWorkout() * fitnessPointsRepository.getActivityPoints("SpeedWorkout").getPoints();
        int lightWorkout = requestFitness.lightWorkout() * fitnessPointsRepository.getActivityPoints("LightWorkout").getPoints();
        int moderateWorkout1 = requestFitness.moderateWorkout30Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout30Min").getPoints();
        int moderateWorkout2 = requestFitness.moderateWorkout60Min() * fitnessPointsRepository.getActivityPoints("ModerateWorkout60Min").getPoints();
        int vigorousWorkout = requestFitness.vigorousWorkout() * fitnessPointsRepository.getActivityPoints("VigorousWorkout").getPoints();
        int parkrun = requestFitness.parkrun() * fitnessPointsRepository.getActivityPoints("ParkRun").getPoints();
        int walkrun1 = requestFitness.walkingOrRunningRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel1").getPoints();
        int walkrun2 = requestFitness.walkingOrRunningRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel2").getPoints();
        int walkrun3 = requestFitness.walkingOrRunningRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel3").getPoints();
        int walkrun4 = requestFitness.walkingOrRunningRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("WalkingOrRunningRaceEventLevel4").getPoints();
        int swimming1= requestFitness.swimmingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel1").getPoints();
        int swimming2 = requestFitness.swimmingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel2").getPoints();
        int swimming3 = requestFitness.swimmingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel3").getPoints();
        int swimming4 = requestFitness.swimmingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("SwimmingRaceEventLevel4").getPoints();
        int cycling1= requestFitness.cyclingRaceEventLevel1() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel1").getPoints();
        int cycling2 = requestFitness.cyclingRaceEventLevel2() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel2").getPoints();
        int cycling3 = requestFitness.cyclingRaceEventLevel3() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel3").getPoints();
        int cycling4 = requestFitness.cyclingRaceEventLevel4() * fitnessPointsRepository.getActivityPoints("CyclingRaceEventLevel4").getPoints();
        int sum = walking1 + walking2 + onlineWorkout + speedWorkout + lightWorkout + moderateWorkout1 + moderateWorkout2
                + vigorousWorkout + parkrun + walkrun1 + walkrun2 + walkrun3 + walkrun4 + swimming1 + swimming2
                + swimming3 + swimming4 + cycling1 + cycling2 + cycling3 + cycling4;
        return new ResponsePoints(Math.min(sum, 30000));
    }
}

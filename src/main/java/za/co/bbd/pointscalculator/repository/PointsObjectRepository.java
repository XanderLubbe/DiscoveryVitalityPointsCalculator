package za.co.bbd.pointscalculator.repository;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.HealthyFoods;
import za.co.bbd.pointscalculator.model.HealthCheck;
@Service
public class PointsObjectRepository {
    public HealthyFoods findFoodPoints(boolean dietitianVisit, int healthyFoodPerMonth){
        int dietitianPoints = 0;
        if (dietitianVisit){
            dietitianPoints = 1000;
        }
        int foodPoints;

        if (healthyFoodPerMonth > 2000){
            foodPoints = 12000;
        }
        else if (healthyFoodPerMonth > 1500){
            foodPoints = 10818;
        }
        else if (healthyFoodPerMonth > 1000){
            foodPoints = 7681;
        }
        else if (healthyFoodPerMonth > 500){
            foodPoints = 4614;
        }
        else{
            foodPoints = 1572;
        }

        return new HealthyFoods(foodPoints, dietitianPoints);
    }
    
    public HealthCheck findHealthCheckPoints( boolean vitalityAge,
                                                int mentalWellbeing,
                                                int golfPlayed,
                                                boolean fluVaccine,
                                                boolean initialHIVTest,
                                                boolean annualHIVTest,
                                                boolean papSmear,
                                                boolean mammogram,
                                                boolean colonoscopy,
                                                boolean dentalCheck,
                                                boolean glaucomaScreening,
                                                boolean managingChronicCondition,
                                                boolean bloodPressue,
                                                boolean bloodGlucose,
                                                boolean cholestrol,
                                                boolean weightAssesment,
                                                boolean nonSmokersDeclaration){

                                                    
        return new HealthCheck(
            vitalityAge,
            mentalWellbeing,
            golfPlayed,
            fluVaccine,
            initialHIVTest,
            annualHIVTest,
            papSmear,
            mammogram,
            colonoscopy,
            dentalCheck,
            glaucomaScreening,
            managingChronicCondition,
            bloodPressue,
            bloodGlucose,
            cholestrol,
            weightAssesment,
            nonSmokersDeclaration
        );
    }
}

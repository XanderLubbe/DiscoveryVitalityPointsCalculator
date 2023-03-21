package za.co.bbd.pointscalculator.repository;

import org.springframework.stereotype.Service;

import za.co.bbd.pointscalculator.model.Activity;
import za.co.bbd.pointscalculator.model.HealthyFoods;

import java.util.ArrayList;

import za.co.bbd.pointscalculator.model.HealthCheck;
@Service
public class PointsObjectRepository {

    ArrayList<Activity> activities = new ArrayList<>();

    public PointsObjectRepository(){
        populate();
    }
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

    public int getActivityPoints(int id){
        for(Activity a : activities){
            if(a.getId() == id){
                return a.getPoints();
            }
        }
        return 0;
    }

    private void populate(){
        activities.add(new Activity(1,"Walking +5000", "5000-9999 steps",50 ));
        activities.add(new Activity(2,"Walking +10000", "10000+ steps",100 ));
        activities.add(new Activity(3,"Online Workout", "30+ min",100 ));
        activities.add(new Activity(4,"Speed Workout", "30+ min",100 ));
        activities.add(new Activity(5,"Light Workout", "30+ min",100 ));
        activities.add(new Activity(6,"Moderate Workout 30Min", "30-59 min",200 ));
        activities.add(new Activity(7,"Moderate Workout 60Min", "60+ min",300 ));
        activities.add(new Activity(8,"Vigorous Workout", "30+ min",300 ));
        activities.add(new Activity(9,"Park run", "5Km",300 ));
        activities.add(new Activity(10,"Walking/RunningRaceEventOption1", "5-9km", 300));
        activities.add(new Activity(11,"Walking/RunningRaceEventOption2", "10-20km", 600));
        activities.add(new Activity(12,"Walking/RunningRaceEventOption3", "10-20km", 1500));
        activities.add(new Activity(13,"Walking/RunningRaceEventOption4", "42km+", 3000));
        activities.add(new Activity(14,"SwimmingRaceEventOption1", "0.5-1km", 300));
        activities.add(new Activity(15,"SwimmingRaceEventOption2", "1.1-3km", 600));
        activities.add(new Activity(16,"SwimmingRaceEventOption3", "3.1-5.9km", 1500));
        activities.add(new Activity(17,"SwimmingRaceEventOption4", "6km+", 3000));
        activities.add(new Activity(18,"CyclingRaceEventOption1", "25-49km", 300));
        activities.add(new Activity(19,"CyclingRaceEventOption2", "50-99km", 600));
        activities.add(new Activity(20,"CyclingRaceEventOption3",  "100-179km", 1500));
        activities.add(new Activity(21,"CyclingRaceEventOption4", "180km+", 3000));
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
                                                boolean bloodPressure,
                                                boolean bloodGlucose,
                                                boolean cholestrol,
                                                boolean weightAssesment,
                                                boolean nonSmokersDeclaration){

        // Discovery Logic Limits
        int HealthCheckLimit = 28000;
        int aboveLimitFix = 0;
        int mentalWellbeingLimit =2;

        
        // General
        int vitalityAgePoints = 0;
        if (vitalityAge){
            vitalityAgePoints= 1500;
        }

        int mentalWellbeingPoints = mentalWellbeing * 500; //int represents number of check done
        if(mentalWellbeing>mentalWellbeingLimit){
            System.err.println("More than" + mentalWellbeingLimit + "mentalWellbeing checks is not allowed");
        }

        // Excercise
        int golfPlayedPoints =  golfPlayed * 100;
        
        // Health Checks
        int fluVaccinePoints = 0;
        if (fluVaccine) {
            fluVaccinePoints = 1000;
        }

        int initialHIVTestPoints = 0;
        if (initialHIVTest) {
            initialHIVTestPoints = 7500;
        }

        int annualHIVTestPoints = 0;
        if (annualHIVTest) {
            annualHIVTestPoints = 1000;
        }

        int papSmearPoints = 0;
        if (papSmear) {
            papSmearPoints = 2500;
        }
        
        int mammogramPoints = 0;
        if (mammogram){
            mammogramPoints =2500;
        }
        
        int colonoscopyPoints = 0;
        if (colonoscopy){
            colonoscopyPoints = 2500;
        }
        
        int dentalCheckPoints = 0;
        if (dentalCheck) {
            dentalCheckPoints = 1000;
        }
        
        int glaucomaScreeningPoints = 0;
        if (glaucomaScreening){
            glaucomaScreeningPoints = 2500;
        }
         
        int managingChronicConditionPoints = 0;
        if (managingChronicCondition){
            managingChronicConditionPoints = 2500;
        }
        

        // Vitality Checks
        int vitalityCheckPoints; 
        
        int numHighRisk = 0;
        if (!bloodPressure) {
            numHighRisk += 1;
        }
        if (!bloodGlucose) {
            numHighRisk += 1;
        }
        if (!cholestrol) {
            numHighRisk += 1;
        }
        if (!weightAssesment) {
            numHighRisk += 1;
        }
        if (!nonSmokersDeclaration) {
            numHighRisk += 1;
        }

        
        // Vitality Checks Logic
        if (numHighRisk==0){
            vitalityCheckPoints =22500;
        }
        else if (numHighRisk==1){
            vitalityCheckPoints = 12500;
        }
        else {
            vitalityCheckPoints = 5000;
        }
        
        int totalHealthCheckPoints = vitalityAgePoints + mentalWellbeingPoints + golfPlayedPoints + fluVaccinePoints + initialHIVTestPoints + annualHIVTestPoints + papSmearPoints + mammogramPoints + colonoscopyPoints + dentalCheckPoints + glaucomaScreeningPoints + managingChronicConditionPoints + vitalityCheckPoints;
        //Rudamentary fix for going above limit. Will lose detail.
        if (totalHealthCheckPoints>HealthCheckLimit){
            System.err.println("Total points from healthCheck("+ totalHealthCheckPoints +") are above the(" +HealthCheckLimit+ ") limit!");
            aboveLimitFix = HealthCheckLimit;
            vitalityAgePoints = 0;
            mentalWellbeingPoints = 0;
            golfPlayedPoints = 0;
            fluVaccinePoints = 0;
            initialHIVTestPoints = 0;
            annualHIVTestPoints = 0;
            papSmearPoints = 0;
            mammogramPoints = 0;
            colonoscopyPoints = 0;
            dentalCheckPoints = 0;
            glaucomaScreeningPoints = 0;
            managingChronicConditionPoints = 0;
            vitalityCheckPoints = 0;
        }

        return new HealthCheck( vitalityAgePoints,
                                mentalWellbeingPoints,
                                golfPlayedPoints,
                                fluVaccinePoints,
                                initialHIVTestPoints,
                                annualHIVTestPoints,
                                papSmearPoints,
                                mammogramPoints,
                                colonoscopyPoints,
                                dentalCheckPoints,
                                glaucomaScreeningPoints,
                                managingChronicConditionPoints,
                                vitalityCheckPoints,
                                aboveLimitFix
        );
    }
}

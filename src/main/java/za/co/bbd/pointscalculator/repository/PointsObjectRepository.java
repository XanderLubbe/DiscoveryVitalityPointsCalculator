package za.co.bbd.pointscalculator.repository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import za.co.bbd.pointscalculator.model.HealthCheck;
@Service
public class PointsObjectRepository {

    public PointsObjectRepository(){
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

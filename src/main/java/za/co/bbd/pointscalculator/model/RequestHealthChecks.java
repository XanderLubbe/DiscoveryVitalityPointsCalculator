package za.co.bbd.pointscalculator.model;

import lombok.Getter;

@Getter
public class RequestHealthChecks {
    // General
    private boolean vitalityAge;
    private int mentalWellbeing;
    // Exercise
    private int golfPlayed;

    // Further Health Checks
    private boolean firstHIVTest;
    private boolean fluVaccine;			
    private boolean initialHIVTest;			
    private boolean annualHIVTest;			
    private boolean papSmear;				
    private boolean mammogram;					
    private boolean colonoscopy;				
    private boolean dentalCheck;				
    private boolean glaucomaScreening; 		
    private boolean managingChronicCondition;

    // Vitality Health Check (check if all are in range)
    private boolean bloodPressue;
	private boolean bloodGlucose;
	private boolean cholestrol;
	private boolean weightAssesment;
	private boolean nonSmokersDeclaration;

    public RequestHealthChecks(boolean firstHIVTest, boolean bloodGlucose){
        this.firstHIVTest = firstHIVTest;
        this.bloodGlucose = bloodGlucose;
    }

    
}

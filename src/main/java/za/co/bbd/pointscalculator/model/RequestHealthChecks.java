package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestHealthChecks {

    // General
    private boolean vitalityAge;
    private int mentalWellbeing;

    // Exercise
    private int golfPlayed;

    // Further Health Checks
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

    
}

package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record RequestHealthChecks (

    // General
    boolean vitalityAge,
    int mentalWellbeing,

    // Exercise
    int golfPlayed,

    // Further Health Checks
    boolean fluVaccine,
    boolean initialHIVTest,
    boolean annualHIVTest,
    boolean papSmear,
    boolean mammogram,
    boolean colonoscopy,
    boolean dentalCheck,
    boolean glaucomaScreening,
    boolean managingChronicCondition,

    // Vitality Health Check (check if all are in range)
    boolean bloodPressure,
	boolean bloodGlucose,
	boolean cholestrol,
	boolean weightAssesment,
    boolean nonSmokersDeclaration


){}

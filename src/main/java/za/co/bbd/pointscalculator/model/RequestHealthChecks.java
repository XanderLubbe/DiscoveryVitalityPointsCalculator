package za.co.bbd.pointscalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


public record RequestHealthChecks (
    boolean vitalityAge,
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
	boolean nonSmokersDeclaration){}

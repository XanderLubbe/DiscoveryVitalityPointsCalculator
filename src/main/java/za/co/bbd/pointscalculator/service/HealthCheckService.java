package za.co.bbd.pointscalculator.service;

import org.json.JSONObject;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.model.HealthCheck;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.repository.HealthChecksPointsRepository;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class HealthCheckService {

    private final PointsObjectRepository repository; // TODO: Remove

    private final HealthChecksPointsRepository healthCheckPointsRepository;

    HealthCheckService(PointsObjectRepository repository, HealthChecksPointsRepository healthCheckPointsRepository) {
        this.repository = repository;
        this.healthCheckPointsRepository = healthCheckPointsRepository;
    }

    public ResponsePoints findHealthCheckPointsService(RequestHealthChecks requestHealthChecks) {

        // Gets points from Health Check Repo for each check
        int vitalityAgePoints = healthCheckPointsRepository.getCheckPoints("VitalityAge").getPoints();
        int mentalWellbeingPoints = healthCheckPointsRepository.getCheckPoints("mentalWellbeing").getPoints();
        int golfPlayedPoints = healthCheckPointsRepository.getCheckPoints("golfPlayed").getPoints();
        int fluVaccinePoints = healthCheckPointsRepository.getCheckPoints("fluVaccine").getPoints();
        int initialHIVTestPoints = healthCheckPointsRepository.getCheckPoints("initialHIVTest").getPoints();
        int annualHIVTestPoints = healthCheckPointsRepository.getCheckPoints("annualHIVTest").getPoints();
        int papSmearPoints = healthCheckPointsRepository.getCheckPoints("papSmear").getPoints();
        int mammogramPoints = healthCheckPointsRepository.getCheckPoints("mammogram").getPoints();
        int colonoscopyPoints = healthCheckPointsRepository.getCheckPoints("colonoscopy").getPoints();
        int dentalCheckPoints = healthCheckPointsRepository.getCheckPoints("dentalCheck").getPoints();
        int glaucomaScreeningPoints = healthCheckPointsRepository.getCheckPoints("glaucomaScreening").getPoints();
        int managingChronicConditionPoints = healthCheckPointsRepository.getCheckPoints("managingChronicCondition")
                .getPoints();
        int bloodPressurePoints = healthCheckPointsRepository.getCheckPoints("bloodPressure").getPoints();
        int bloodGlucosePoints = healthCheckPointsRepository.getCheckPoints("bloodGlucose").getPoints();
        int cholestrolPoints = healthCheckPointsRepository.getCheckPoints("cholestrol").getPoints();
        int weightAssesmentPoints = healthCheckPointsRepository.getCheckPoints("weightAssesment").getPoints();
        int nonSmokersDeclarationPoints = healthCheckPointsRepository.getCheckPoints("nonSmokersDeclaration")
                .getPoints();
        int healthCheckLimitPoints = healthCheckPointsRepository.getCheckPoints("HealthCheckLimit").getPoints();

        // Logic for calculating how much points to return for each check
        int returned_vitalityAge = 0;
        if (requestHealthChecks.isVitalityAge()) {
            returned_vitalityAge = vitalityAgePoints;
        }
        int returned_mentalWellbeing = requestHealthChecks.getMentalWellbeing() * mentalWellbeingPoints;
        int returned_golfPlayed = requestHealthChecks.getGolfPlayed() * golfPlayedPoints;
        int returned_fluVaccine = 0;
        if (requestHealthChecks.isFluVaccine()) {
            returned_fluVaccine = fluVaccinePoints;
        }
        int returned_initialHIVTest = 0;
        if (requestHealthChecks.isInitialHIVTest()) {
            returned_initialHIVTest = initialHIVTestPoints;
        }
        int returned_annualHIVTest = 0;
        if (requestHealthChecks.isAnnualHIVTest()) {
            returned_annualHIVTest = annualHIVTestPoints;
        }
        int returned_papSmear = 0;
        if (requestHealthChecks.isPapSmear()) {
            returned_papSmear = papSmearPoints;
        }
        int returned_mammogram = 0;
        if (requestHealthChecks.isMammogram()) {
            returned_mammogram = mammogramPoints;
        }
        int returned_colonoscopy = 0;
        if (requestHealthChecks.isColonoscopy()) {
            returned_colonoscopy = colonoscopyPoints;
        }
        int returned_dentalCheck = 0;
        if (requestHealthChecks.isDentalCheck()) {
            returned_dentalCheck = dentalCheckPoints;
        }
        int returned_glaucomaScreening = 0;
        if (requestHealthChecks.isGlaucomaScreening()) {
            returned_glaucomaScreening = glaucomaScreeningPoints;
        }
        int returned_managingChronicCondition = 0;
        if (requestHealthChecks.isManagingChronicCondition()) {
            returned_managingChronicCondition = managingChronicConditionPoints;
        }

        int returned_bloodPressure = 0;
        if (requestHealthChecks.isBloodPressure()) {
            returned_bloodPressure = bloodPressurePoints;
        }
        int returned_bloodGlucose = 0;
        if (requestHealthChecks.isBloodGlucose()) {
            returned_bloodGlucose = bloodGlucosePoints;
        }
        int returned_cholestrol = 0;
        if (requestHealthChecks.isCholestrol()) {
            returned_cholestrol = cholestrolPoints;
        }
        int returned_weightAssesment = 0;
        if (requestHealthChecks.isWeightAssesment()) {
            returned_weightAssesment = weightAssesmentPoints;
        }
        int returned_nonSmokersDeclaration = 0;
        if (requestHealthChecks.isNonSmokersDeclaration()) {
            returned_nonSmokersDeclaration = nonSmokersDeclarationPoints;
        }

        int returned_aboveLimitFix = 0;

        int totalHealthCheckPoints = returned_vitalityAge + returned_mentalWellbeing + returned_golfPlayed
                + returned_fluVaccine + returned_initialHIVTest + returned_annualHIVTest + returned_papSmear
                + returned_mammogram + returned_colonoscopy + returned_dentalCheck + returned_glaucomaScreening
                + returned_managingChronicCondition + returned_bloodPressure + returned_bloodGlucose
                + returned_cholestrol + returned_weightAssesment + returned_nonSmokersDeclaration;

        // Rudamentary fix for going above limit. Will lose detail.
        if (totalHealthCheckPoints > healthCheckLimitPoints) {
            System.err.println("Total points from healthCheck(" + totalHealthCheckPoints + ") are above the("
                    + healthCheckLimitPoints + ") limit!");
            returned_vitalityAge = 0;
            returned_mentalWellbeing = 0;
            returned_golfPlayed = 0;
            returned_fluVaccine = 0;
            returned_initialHIVTest = 0;
            returned_annualHIVTest = 0;
            returned_papSmear = 0;
            returned_mammogram = 0;
            returned_colonoscopy = 0;
            returned_dentalCheck = 0;
            returned_glaucomaScreening = 0;
            returned_managingChronicCondition = 0;

            returned_aboveLimitFix = healthCheckLimitPoints;
        }

        return new ResponsePoints(returned_vitalityAge +
                returned_mentalWellbeing +
                returned_golfPlayed +
                returned_fluVaccine +
                returned_initialHIVTest +
                returned_annualHIVTest +
                returned_papSmear +
                returned_mammogram +
                returned_colonoscopy +
                returned_dentalCheck +
                returned_glaucomaScreening +
                returned_managingChronicCondition +
                returned_bloodPressure +
                returned_bloodGlucose +
                returned_cholestrol +
                returned_weightAssesment +
                returned_nonSmokersDeclaration +
                returned_aboveLimitFix);
    }

}

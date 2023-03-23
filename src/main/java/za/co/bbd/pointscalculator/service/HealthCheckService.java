package za.co.bbd.pointscalculator.service;

import org.json.JSONObject;

import org.springframework.stereotype.Service;
import za.co.bbd.pointscalculator.model.ResponsePoints;
import za.co.bbd.pointscalculator.model.HealthCheck;
import za.co.bbd.pointscalculator.model.RequestHealthChecks;
import za.co.bbd.pointscalculator.repository.PointsObjectRepository;

@Service
public class HealthCheckService {

    private final PointsObjectRepository repository;

    HealthCheckService(PointsObjectRepository repository) {
        this.repository = repository;
    }

    public ResponsePoints findHealthCheckPointsService(RequestHealthChecks requestHealthChecks) {

        HealthCheck repoHealthCheck = repository.findHealthCheckPoints(requestHealthChecks.isVitalityAge(),
                requestHealthChecks.getMentalWellbeing(),
                requestHealthChecks.getGolfPlayed(),
                requestHealthChecks.isFluVaccine(),
                requestHealthChecks.isInitialHIVTest(),
                requestHealthChecks.isAnnualHIVTest(),
                requestHealthChecks.isPapSmear(),
                requestHealthChecks.isMammogram(),
                requestHealthChecks.isColonoscopy(),
                requestHealthChecks.isDentalCheck(),
                requestHealthChecks.isGlaucomaScreening(),
                requestHealthChecks.isManagingChronicCondition(),
                requestHealthChecks.isBloodPressure(),
                requestHealthChecks.isBloodGlucose(),
                requestHealthChecks.isCholestrol(),
                requestHealthChecks.isWeightAssesment(),
                requestHealthChecks.isNonSmokersDeclaration());

        int returned_vitalityAgePoints = repoHealthCheck.vitalityAgePoints();
        int returned_mentalWellbeing = repoHealthCheck.mentalWellbeingPoints();
        int returned_golfPlayed = repoHealthCheck.golfPlayedPoints();
        int returned_fluVaccine = repoHealthCheck.fluVaccinePoints();
        int returned_initialHIVTest = repoHealthCheck.initialHIVTestPoints();
        int returned_annualHIVTest = repoHealthCheck.annualHIVTestPoints();
        int returned_papSmear = repoHealthCheck.papSmearPoints();
        int returned_mammogram = repoHealthCheck.mammogramPoints();
        int returned_colonoscopy = repoHealthCheck.colonoscopyPoints();
        int returned_dentalCheck = repoHealthCheck.dentalCheckPoints();
        int returned_glaucomaScreening = repoHealthCheck.glaucomaScreeningPoints();
        int returned_managingChronicCondition = repoHealthCheck.managingChronicConditionPoints();
        int returned_vitalityCheckPoints = repoHealthCheck.vitalityCheckPoints();
        int returned_aboveLimitFix = repoHealthCheck.aboveLimitFix();

        int[] totalPoints = { returned_vitalityAgePoints,
                returned_mentalWellbeing,
                returned_golfPlayed,
                returned_fluVaccine,
                returned_initialHIVTest,
                returned_annualHIVTest,
                returned_papSmear,
                returned_mammogram,
                returned_colonoscopy,
                returned_dentalCheck,
                returned_glaucomaScreening,
                returned_managingChronicCondition,
                returned_vitalityCheckPoints,
                returned_aboveLimitFix };

        return new ResponsePoints(returned_vitalityAgePoints +
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
                returned_vitalityCheckPoints +
                returned_aboveLimitFix);
    }

}

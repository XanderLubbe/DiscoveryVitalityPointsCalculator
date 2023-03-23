--test inserts for the table
INSERT INTO FITNESS_POINTS (ID, ACTIVITY, POINTS) VALUES (1, 'walking', 50);
INSERT INTO FITNESS_POINTS (ID, ACTIVITY, POINTS) VALUES (2, 'running', 100);
INSERT INTO FITNESS_POINTS (ID, ACTIVITY, POINTS) VALUES (3, 'dentistCheckup', 100);
INSERT INTO FITNESS_POINTS (ID, ACTIVITY, POINTS) VALUES (4, 'dieticianVisit', 100);
INSERT INTO FITNESS_POINTS (ID, ACTIVITY, POINTS) VALUES (5, 'Other', 100);

--Vitality bands table
INSERT INTO VITALITY_BANDS (ID, LOWER_LIMIT, UPPER_LIMIT, BAND) VALUES (1, 0, 7500, 'Blue');
INSERT INTO VITALITY_BANDS (ID, LOWER_LIMIT, UPPER_LIMIT, BAND) VALUES (2, 7500, 25000, 'Bronze');
INSERT INTO VITALITY_BANDS (ID, LOWER_LIMIT, UPPER_LIMIT, BAND) VALUES (3, 25000, 40000, 'Gold');
INSERT INTO VITALITY_BANDS (ID, LOWER_LIMIT, UPPER_LIMIT, BAND) VALUES (4, 50000, 5000, 'Silver');
INSERT INTO VITALITY_BANDS (ID, LOWER_LIMIT, UPPER_LIMIT, BAND) VALUES (5, 50000, 200000, 'Diamond');


INSERT INTO HEALTHY_FOODS(ID, LOWER_LIMIT, UPPER_LIMIT, POINTS) VALUES(1,0,500, 1572);
INSERT INTO HEALTHY_FOODS(ID, LOWER_LIMIT, UPPER_LIMIT, POINTS) VALUES(2,501,1000, 4614);
INSERT INTO HEALTHY_FOODS(ID, LOWER_LIMIT, UPPER_LIMIT, POINTS) VALUES(3,1001,1500, 7681);
INSERT INTO HEALTHY_FOODS(ID, LOWER_LIMIT, UPPER_LIMIT, POINTS) VALUES(4,1501,2000, 10818);
INSERT INTO HEALTHY_FOODS(ID, LOWER_LIMIT, UPPER_LIMIT, POINTS) VALUES(5,2001,2147483647, 12000);

-- TODO: Add in the different types of health check points you can get

INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (1, "VitalityAge", 1500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (2, "MentalWellbeing", 500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (3, "GolfPlayed", 100)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (4, "FluVaccine", 1000)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (5, "InitialHIVTest", 7500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (6, "AnnualHIVTest", 1000)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (7, "PapSmear", 2500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (8, "Mammogram", 2500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (9, "Colonoscopy", 2500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (10, "DentalCheck", 1000)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (11, "GlaucomaScreening", 2500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (12, "ManagingChronicCondition", 2500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (13, "BloodPressure", 4500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (14, "BloodGlucose", 4500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (15, "Cholesterol", 4500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (16, "WeightAssesment", 4500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (17, "NonSmokersDeclaration", 4500)
INSERT INTO HEALTH_CHECKS(ID, CHECK, POINTS) VALUES (18, "HealthCheckLimit", 22500)
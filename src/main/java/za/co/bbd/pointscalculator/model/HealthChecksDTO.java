package za.co.bbd.pointscalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name="HEALTH_CHECKS")
// change all of these to suit your needs
public record HealthChecksDTO (
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long Id,
    int lowerLimit,
    int upperLimit,
    String band){}



package za.co.bbd.pointscalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name="HEALTH_CHECKS")
@Getter
// change all of these to suit your needs
public class HealthChecksDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long Id;
    private int lowerLimit;
    private int upperLimit;
    private String band;
}


